package com.newtine.model.service;

import java.util.List;

import com.newtine.model.dto.ReviewDto;

public interface ReviewService {
	public List<ReviewDto> getReviewList(int id);
	
	ReviewDto selectReviewById(int id);
	
	public int insertReview(ReviewDto reviewDto);
	
	int deleteReview(int reviewNo);

	int updateReview(ReviewDto reviewDto);
}
