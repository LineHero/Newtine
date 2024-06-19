package com.newtine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtine.model.dto.UserDto;
import com.newtine.model.dto.VideoDto;
import com.newtine.model.service.VideoService;

@RestController
@RequestMapping("/admin/video")
public class VideoController {

	private final VideoService videoService;
	
	@Autowired
	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllVideos(){
		List<VideoDto> list = videoService.getAllVideos();
		return new ResponseEntity<List<VideoDto>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertVideo(@ModelAttribute VideoDto video) {
		videoService.insertVideo(video);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<?> deleteVideo(@PathVariable("no") int no) {
		videoService.deleteVideo(no);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
