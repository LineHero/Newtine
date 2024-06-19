package com.newtine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtine.model.dto.ReviewDto;
import com.newtine.model.service.MylistService;
import com.newtine.model.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	private final ReviewService reviewService;
	private final MylistService mylistService;
	
	@Autowired
	public ReviewController(ReviewService reviewService, MylistService mylistService) {
		this.reviewService = reviewService;
		this.mylistService = mylistService;
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<?> getReviewList(@PathVariable("id") int id) {
		List<ReviewDto> list = reviewService.getReviewList(id);
		return new ResponseEntity<List<ReviewDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/review/{id}")
	public ResponseEntity<?> selectReviewById(@PathVariable("id") int id){
		ReviewDto review = reviewService.selectReviewById(id);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
	
	@PostMapping("/review")
	public ResponseEntity<?> insertReview(@RequestBody ReviewDto reviewDto){
		try {
			int result = reviewService.insertReview(reviewDto);
			mylistService.updateRate();
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED); 
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateReview(@RequestBody ReviewDto reviewDto ,@PathVariable("id") int reviewNo){
		reviewDto.setReviewNo(reviewNo);
		int res = reviewService.updateReview(reviewDto);
		
		//수정이 되지 않았다면 not found
		return new ResponseEntity<>(res==1 ? HttpStatus.OK : HttpStatus.NOT_FOUND); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReview(@PathVariable("id") int reviewNo){
		int res = reviewService.deleteReview(reviewNo);
		
		//삭제가 되지 않았다면 not found
		return new ResponseEntity<>(res==1 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
}
