package com.newtine.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newtine.model.dao.CommentDao;
import com.newtine.model.dto.CommentDto;

@Service
public class CommentServiceImpl implements CommentService {

	private final CommentDao commentDao;
	
	@Autowired
	public CommentServiceImpl (CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	public List<CommentDto> getCommentList(int id) {
		return commentDao.getCommentList(id);
	}
	
	@Override
    public CommentDto selectCommentById(int id) {
        return commentDao.selectCommentById(id);
    }

    @Override
    public int insertComment(CommentDto commentDto) {
        return commentDao.insertComment(commentDto);
    }

    @Override
    public int deleteComment(int commentNo) {
        return commentDao.deleteComment(commentNo);
    }

    @Override
    public int updateComment(CommentDto commentDto) {
        return commentDao.updateComment(commentDto);
    }
}
