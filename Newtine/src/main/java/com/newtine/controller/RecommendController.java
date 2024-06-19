package com.newtine.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtine.model.dto.MylistDto;
import com.newtine.model.dto.RecommendDto;
import com.newtine.model.dto.UserDto;
import com.newtine.model.service.MylistService;
import com.newtine.model.service.MypageService;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

	private final MylistService mylistService;
	private final MypageService mypageService;
	
	public RecommendController(MylistService mylistService, MypageService mypageService) {
		this.mylistService = mylistService;
		this.mypageService = mypageService;
	}
	
    private List<MylistDto> getRandomElements(List<MylistDto> list, int numberOfElements) {
        Random rand = new Random();
        List<MylistDto> copy = new ArrayList<>(list);
        Collections.shuffle(copy, rand);
        return copy.subList(0, Math.min(numberOfElements, copy.size()));
    }
	
	@PostMapping("")
	public ResponseEntity<?> getrecommend(@RequestBody RecommendDto recommend) {
		Map<String, Integer> selected = new HashMap<>();	
		selected.put("place", recommend.getPlace());
		selected.put("part", recommend.getPart());
		selected.put("time", recommend.getTime());
		
		List<MylistDto> selectedList = mylistService.getrecommend(selected);
		
		if (selectedList.size() > 3) {
			List<MylistDto> randomSelectedList = getRandomElements(selectedList, 3);
			return new ResponseEntity<List<MylistDto>>(randomSelectedList, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<MylistDto>>(selectedList, HttpStatus.OK);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getusernobyid(@PathVariable("userId") String userId) {
		UserDto user = mypageService.getuserbyid(userId);
		int userNo = user.getUserNo();
		System.out.println(userNo);
		return new ResponseEntity<Integer>(userNo, HttpStatus.OK);
	}
	
	
}
