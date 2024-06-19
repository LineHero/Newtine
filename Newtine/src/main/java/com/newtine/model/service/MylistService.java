package com.newtine.model.service;

import java.util.List;
import java.util.Map;

import com.newtine.model.dto.ListdetailDto;
import com.newtine.model.dto.MylistDto;
import com.newtine.model.dto.ReviewDto;
import com.newtine.model.dto.SearchConditionDto;
import com.newtine.model.dto.UrlDto;

public interface MylistService {

	public List<MylistDto> getAllmylist(Map<String, Integer> m);
	
	public MylistDto getlistdetail(int id);
	
	public List<MylistDto> searchmylist(SearchConditionDto sc);
	
	public int insertMylist(MylistDto mylistDto);
	
	public int insertMylistDetail(ListdetailDto listdetailDto);
	
	public List<MylistDto> getAllLists();
	
	void increaseListViewCount(int id);
	
	List<ListdetailDto> getAllListVideos(int listNo);
	
	List<MylistDto> getrecommend(Map<String, Integer> selected);
	
	public void insertMylisturl(UrlDto url);
	
	void updateRate();
}
