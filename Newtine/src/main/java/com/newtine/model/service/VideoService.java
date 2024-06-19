package com.newtine.model.service;

import java.util.List;

import com.newtine.model.dto.VideoDto;

public interface VideoService {
	
	List<VideoDto> getAllVideos();

	public void insertVideo(VideoDto video);
	
	public void deleteVideo(int no);
}
