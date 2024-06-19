package com.newtine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtine.model.dto.ListdetailDto;
import com.newtine.model.dto.MylistDto;
import com.newtine.model.dto.SearchConditionDto;
import com.newtine.model.dto.UrlDto;
import com.newtine.model.dto.VideoDto;
import com.newtine.model.service.MylistService;

@RestController
@RequestMapping("/routine")
public class MylistController {
	
	private final MylistService mylistService;
	
	@Autowired
	public MylistController(MylistService mylistService) {
		this.mylistService = mylistService;
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> list(@RequestBody SearchConditionDto searchCondition) {
		Map<String, Integer> m = new HashMap<>();
		
		m.put("offset", searchCondition.getPage() * 10);
		m.put("part", searchCondition.getPart());
		
		if (searchCondition.getPart() == 0) {
			if (searchCondition.getIsofficial() != 0) {
				if (searchCondition.getIsofficial() == 1) {
					m.put("isofficial", 1);
				}
				else {
					m.put("isofficial", 2);
				}
			}
			else if (searchCondition.getSearchquery() != "") {
				searchCondition.setPage(searchCondition.getPage() * 10);
				List<MylistDto> slist = mylistService.searchmylist(searchCondition);
				return new ResponseEntity<List<MylistDto>>(slist, HttpStatus.OK);
			}
		}
		
		List<MylistDto> list = mylistService.getAllmylist(m);
		return new ResponseEntity<List<MylistDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/list/detail/{id}")
	public ResponseEntity<?> getlistdetail(@PathVariable("id") int id) {
		mylistService.increaseListViewCount(id);
		MylistDto list = mylistService.getlistdetail(id);
		return new ResponseEntity<MylistDto>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllLists(){
		List<MylistDto> list = mylistService.getAllLists();
		return new ResponseEntity<List<MylistDto>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> insertMylist(@RequestBody MylistDto mylistDto){
		try {
			int result = mylistService.insertMylist(mylistDto);
			return new ResponseEntity<Integer>(mylistDto.getListNo(), HttpStatus.CREATED); 
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
//	@PostMapping("/create/detail")
//	public ResponseEntity<?> insertMylistDetail(@RequestBody ListdetailDto listdetailDto){
//		try {
//			int result = mylistService.insertMylistDetail(listdetailDto);
//			return new ResponseEntity<Integer>(result, HttpStatus.CREATED); 
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	@PostMapping("/create/detail/{listno}")
	public ResponseEntity<?> insertMylistDetail(@PathVariable("listno") int listNo, @RequestBody List<VideoDto> videos){
		
		if (videos != null) {
			
			VideoDto firstvideo = videos.get(0);
			String thumbnail = firstvideo.getVideoURL();
			
			UrlDto mylisturl = new UrlDto();
			mylisturl.setUrl(thumbnail);
			mylisturl.setUserno(listNo);
			
			for (int i = 0; i < videos.size(); i++) {
				VideoDto video = videos.get(i);
				ListdetailDto thislistdetail = new ListdetailDto();
				thislistdetail.setListNo(listNo);
				thislistdetail.setVideoNo(video.getVideoNo());
				mylistService.insertMylistDetail(thislistdetail);
			}
			
			mylistService.insertMylisturl(mylisturl);
			
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/video/{id}")
	public ResponseEntity<?> getAllListVideos(@PathVariable("id") int id){
		List<ListdetailDto> list = mylistService.getAllListVideos(id);
		return new ResponseEntity<List<ListdetailDto>>(list, HttpStatus.OK);
	}
	
}
