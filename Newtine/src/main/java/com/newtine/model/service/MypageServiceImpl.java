package com.newtine.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.newtine.model.dao.MypageDao;
import com.newtine.model.dto.BodyprofileDto;
import com.newtine.model.dto.MylistDto;
import com.newtine.model.dto.StreakDto;
import com.newtine.model.dto.UserDto;
import com.newtine.model.dto.UserfollowlistDto;

@Service
public class MypageServiceImpl implements MypageService {
	
	private final MypageDao mypageDao;
		
	@Value("${upload.path}")
    private String uploadPath; 
	
	public MypageServiceImpl (MypageDao mypageDao) {
		this.mypageDao = mypageDao;
	}
	

	@Override
	public List<BodyprofileDto> getmybodyprofile(int userno) {
		return mypageDao.getmybodyprofile(userno);
	}

	@Override
	public List<StreakDto> getmystreak(int userno) {
		return mypageDao.getmystreak(userno);
	}


	@Override
	public void uploadimage(MultipartFile multipartFile, String userId) {
		if (multipartFile != null && multipartFile.getSize() > 0) {
			try {
				
				String fileName = multipartFile.getOriginalFilename();
				String fileId = UUID.randomUUID().toString() + "_" + fileName;
				
				UserDto user = mypageDao.getuserbyid(userId);
				
				user.setUserProfileFileId(fileId);
				user.setUserProfileFileName(fileName);
	
	            multipartFile.transferTo(new File(uploadPath + "/" + fileId));
			
				mypageDao.updateuser(user);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}


	@Override
	public String getmyprofileimg(String userId) {
		return mypageDao.getmyprofileimg(userId);
	}


	@Override
	public UserDto getuserbyno(int userNo) {
		return mypageDao.getuserbyno(userNo);
	}


	@Override
	public List<UserfollowlistDto> getmyfollowlist(int userNo) {
		return mypageDao.getmyfollowlist(userNo);
	}


	@Override
	public UserDto getuserbyid(String userId) {
		return mypageDao.getuserbyid(userId);
	}


	@Override
	public void unfollow(Map<String, Integer> unfollowing) {
		mypageDao.unfollow(unfollowing);
	}


	@Override
	public void dofollow(Map<String, Integer> unfollowing) {
		mypageDao.dofollow(unfollowing);	
	}


	@Override
	public List<MylistDto> getmylistformypage(int id) {
		
		return mypageDao.getmylistformypage(id);
	}


	@Override
	public void insertbodyprofile(BodyprofileDto bodyprofile) {
		mypageDao.insertbodyprofile(bodyprofile);
		
	}


	@Override
	public void deletemylist(int listNo) {
		mypageDao.deletemylist(listNo);
	}

}
