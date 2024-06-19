package com.newtine.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newtine.model.dao.UserDao;
import com.newtine.model.dto.StreakDto;
import com.newtine.model.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDto getLogin(String id, String password) {
		return userDao.getUserDtoByUserIdAndPassword(id, password);
	}

	@Override
	public boolean signUp(UserDto userDto) {
		if(userDao.getUserDtoByUserId(userDto.getUserId()) != null) {
			return false;
		}
		userDao.registUserDto(userDto);
		return true;
	}

	@Override
	public UserDto getUserDtoByUserId(String userId) {
		return userDao.getUserDtoByUserId(userId);
	}
	
	@Override
    public boolean deleteUser(String id, String password) {
        UserDto user = userDao.getUserDtoByUserIdAndPassword(id, password);
        if (user == null) {
            return false; // 사용자 정보가 일치하지 않음
        }
        return userDao.deleteUserDtoByUserId(id) > 0;
    }
	
	@Override
	public UserDto getUserDetail(int userNo) {
		return userDao.getUserDetail(userNo);
	}
	
	@Override
	public List<UserDto> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Override
	public boolean insertStreak(StreakDto streakDto) {
	    userDao.insertStreak(streakDto);
	    return true; 
	}

}
