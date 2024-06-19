package com.newtine.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newtine.model.dao.ReviewDao;
import com.newtine.model.dto.ReviewDto;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewDao reviewDao;
	
	@Autowired
	public ReviewServiceImpl (ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public ReviewDto selectReviewById(int id) {
		return reviewDao.selectReviewById(id);
	}
	
	@Override
	public List<ReviewDto> getReviewList(int id) {
		return reviewDao.getReviewList(id);
	}
	
	@Override
	public int insertReview(ReviewDto reviewDto) {
		return reviewDao.insertReview(reviewDto);
	}
	
	@Override
	public int deleteReview(int reviewNo) {
		return reviewDao.deleteReview(reviewNo);
	}

	@Override
	public int updateReview(ReviewDto reviewDto) {
		return reviewDao.updateReview(reviewDto);
	}
}
