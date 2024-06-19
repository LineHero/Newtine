package com.newtine.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.newtine.model.dao.MylistDao;
import com.newtine.model.dto.ListdetailDto;
import com.newtine.model.dto.MylistDto;
import com.newtine.model.dto.ReviewDto;
import com.newtine.model.dto.SearchConditionDto;
import com.newtine.model.dto.UrlDto;

@Service
public class MylistServiceImpl implements MylistService {

	private final MylistDao mylistDao;
	
	public MylistServiceImpl (MylistDao mylistDao) {
		this.mylistDao = mylistDao;
	}
	
	
	@Override
	public List<MylistDto> getAllmylist(Map<String, Integer> m) {
		
		return mylistDao.getAllmylist(m);
	}


	@Override
	public MylistDto getlistdetail(int id) {
		return mylistDao.getlistdetail(id);
	}


	@Override
	public List<MylistDto> searchmylist(SearchConditionDto sc) {
		return mylistDao.searchmylist(sc);
	}

	@Override
	public int insertMylist(MylistDto mylistDto) {
		return mylistDao.insertMylist(mylistDto);
	}
	
	@Override
	public int insertMylistDetail(ListdetailDto listdetailDto) {
		return mylistDao.insertMylistDetail(listdetailDto);
	}
	
	@Override
	public List<MylistDto> getAllLists() {
		return mylistDao.getAllLists();
	}
	
	@Override
	public void increaseListViewCount(int id) {
        mylistDao.increaseListViewCount(id);
        return;
    }
	
	@Override
	public List<ListdetailDto> getAllListVideos(int listNo) {
		return mylistDao.getAllListVideos(listNo);
	}


	@Override
	public List<MylistDto> getrecommend(Map<String, Integer> selected) {
		return mylistDao.getrecommend(selected);
	}


	@Override
	public void updateRate() {
		mylistDao.updateRate();
		return;
		
	}

	@Override
	public void insertMylisturl(UrlDto url) {
		mylistDao.insertMylisturl(url);
	}
	
}
