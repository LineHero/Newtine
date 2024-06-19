package com.newtine.model.dao;

import java.util.List;

import com.newtine.model.dto.CommentDto;

public interface CommentDao {
	public List<CommentDto> getCommentList(int id);

	CommentDto selectCommentById(int id);

	// 새로운 댓글을 삽입
	int insertComment(CommentDto commentDto);

	// 댓글 업데이트
	int updateComment(CommentDto commentDto);

	// 댓글 삭제
	int deleteComment(int commentNo);
}
