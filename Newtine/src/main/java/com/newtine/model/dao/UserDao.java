package com.newtine.model.dao;

import java.util.List;

import com.newtine.model.dto.StreakDto;
import com.newtine.model.dto.UserDto;

public interface UserDao {
	public UserDto getUserDtoByUserIdAndPassword(String userId, String userPassword);
	public UserDto getUserDtoByUserId(String userId);
	public void registUserDto(UserDto userDto);
	public int deleteUserDtoByUserId(String userId);
	public UserDto getUserDetail(int userNo);
	public List<UserDto> getAllUsers();
	public boolean insertStreak(StreakDto streakDto);
}
