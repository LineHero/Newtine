package com.newtine.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newtine.model.dao.VideoDao;
import com.newtine.model.dto.UserDto;
import com.newtine.model.dto.VideoDto;

@Service
public class VideoServiceImpl implements VideoService {

	private final VideoDao videoDao;
	
	@Autowired
	public VideoServiceImpl (VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	@Override
	public List<VideoDto> getAllVideos() {
		return videoDao.getAllVideos();
	}
	
	@Override
	public void insertVideo(VideoDto video) {
		videoDao.insertVideo(video);
		return;
	}


	@Override
	public void deleteVideo(int no) {
		videoDao.deleteVideo(no);
	}

}
