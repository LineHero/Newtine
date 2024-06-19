package com.newtine.model.service;

import java.util.List;

import com.newtine.model.dto.StreakDto;
import com.newtine.model.dto.UserDto;

public interface UserService {
	UserDto getLogin(String userId, String userPassword);
	boolean signUp(UserDto userDto);
	UserDto getUserDtoByUserId(String userId);
	boolean deleteUser(String id, String password);
	UserDto getUserDetail(int userNo);
	List<UserDto> getAllUsers();
	boolean insertStreak(StreakDto streakDto);
}
