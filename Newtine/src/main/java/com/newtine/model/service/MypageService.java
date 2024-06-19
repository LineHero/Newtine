package com.newtine.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.newtine.model.dto.BodyprofileDto;
import com.newtine.model.dto.MylistDto;
import com.newtine.model.dto.StreakDto;
import com.newtine.model.dto.UserDto;
import com.newtine.model.dto.UserfollowlistDto;

public interface MypageService {
	
	public List<BodyprofileDto> getmybodyprofile(int userno);
	
	public List<StreakDto> getmystreak(int userno);
	
	public void uploadimage (MultipartFile multipartFile, String userId);
	
	public String getmyprofileimg (String userId);
	
	public UserDto getuserbyno(int userNo);
	
	public List<UserfollowlistDto> getmyfollowlist(int userNo);
	
	public UserDto getuserbyid(String userId);
	
	public void unfollow(Map<String, Integer> unfollowing);
	
	public void dofollow(Map<String, Integer> unfollowing);
	
	public List<MylistDto> getmylistformypage(int id);
	
	public void insertbodyprofile(BodyprofileDto bodyprofile);
	
	public void deletemylist(int listNo);
}
