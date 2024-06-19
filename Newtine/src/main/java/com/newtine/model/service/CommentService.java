package com.newtine.model.service;

import java.util.List;

import com.newtine.model.dto.CommentDto;

public interface CommentService {
	public List<CommentDto> getCommentList(int id);

	CommentDto selectCommentById(int id);

	int insertComment(CommentDto commentDto);

	int deleteComment(int commentNo);

	int updateComment(CommentDto commentDto);
}
