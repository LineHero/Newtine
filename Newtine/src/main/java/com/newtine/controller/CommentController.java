package com.newtine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtine.model.dto.CommentDto;
import com.newtine.model.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	private final CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<?> getCommentList(@PathVariable("id") int id) {
		List<CommentDto> list = commentService.getCommentList(id);
		return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/comment/{id}")
    public ResponseEntity<?> selectCommentById(@PathVariable("id") int id) {
        CommentDto comment = commentService.selectCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<?> insertComment(@RequestBody CommentDto commentDto) {
        try {
            int result = commentService.insertComment(commentDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@RequestBody CommentDto commentDto, @PathVariable("id") int commentNo) {
        commentDto.setCommentNo(commentNo);
        int res = commentService.updateComment(commentDto);
        // 수정이 되지 않았다면 not found
        return new ResponseEntity<>(res == 1 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") int commentNo) {
        int res = commentService.deleteComment(commentNo);
        // 삭제가 되지 않았다면 not found
        return new ResponseEntity<>(res == 1 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
}
