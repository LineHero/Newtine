package com.newtine.model.dao;

import java.util.List;

import com.newtine.model.dto.VideoDto;

public interface VideoDao {
	
	public List<VideoDto> getAllVideos();

	public void insertVideo(VideoDto video);
	
	public void deleteVideo(int no);
}
