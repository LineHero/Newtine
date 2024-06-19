package com.newtine.model.dao;

import java.util.List;

import com.newtine.model.dto.ReviewDto;

public interface ReviewDao {
	public List<ReviewDto> getReviewList(int id);
	
	ReviewDto selectReviewById(int id);
	
	public int insertReview(ReviewDto reviewDto);
	
	int updateReview(ReviewDto reviewDto);

	int deleteReview(int reviewNo);

}
