package com.newtine.model.dao;

import java.util.List;
import java.util.Map;

import com.newtine.model.dto.BodyprofileDto;
import com.newtine.model.dto.MylistDto;
import com.newtine.model.dto.StreakDto;
import com.newtine.model.dto.UserDto;
import com.newtine.model.dto.UserfollowlistDto;


public interface MypageDao {
	public List<BodyprofileDto> getmybodyprofile(int userno);
	
	public List<StreakDto> getmystreak(int userno);
	
	public UserDto getuserbyid(String userId);
	
	public void updateuser(UserDto user);
	
	public String getmyprofileimg(String userId);
	
	public UserDto getuserbyno(int userNo);
	
	public List<UserfollowlistDto> getmyfollowlist(int userNo);
	
	public void unfollow(Map<String, Integer> unfollowing);

	public void dofollow(Map<String, Integer> dofollowing);

	public List<MylistDto> getmylistformypage(int id);

	public void insertbodyprofile(BodyprofileDto bodyprofile);

	public void deletemylist(int listNo);
}
