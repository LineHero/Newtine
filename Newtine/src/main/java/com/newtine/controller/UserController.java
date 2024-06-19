package com.newtine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtine.model.dto.StreakDto;
import com.newtine.model.dto.UserDto;
import com.newtine.model.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> getLogin(@RequestBody Map<String, String> requestMap, HttpServletRequest request) {
	    String id = requestMap.get("id");
	    String pw = requestMap.get("pw");
	    UserDto userDto = userService.getLogin(id, pw);
	    if(userDto == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
	    }
	    HttpSession session = request.getSession();
	    session.setAttribute("loginUser", userDto);
	    session.setMaxInactiveInterval(18000);
	    return ResponseEntity.ok().build(); // 성공적인 로그인 응답
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
		boolean isSignedUp = userService.signUp(userDto);
		if(!isSignedUp) {
			return ResponseEntity.badRequest().body("회원가입에 실패하였습니다. 사용자 정보를 확인해주세요.");
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteUser(@RequestBody Map<String, String> requestMap, HttpSession session) {
	    String id = requestMap.get("id");
	    String password = requestMap.get("password");
	    UserDto loginUser = (UserDto) session.getAttribute("loginUser");

	    boolean isDeleted = userService.deleteUser(id, password);
	    if (!isDeleted) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원 탈퇴에 실패하였습니다.");
	    }
	    session.invalidate();
	    return ResponseEntity.ok().body("회원 탈퇴가 성공적으로 처리되었습니다.");
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getUserDetail(@PathVariable("id") int id) {
		UserDto user = userService.getUserDetail(id);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllUsers(){
		List<UserDto> list = userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/streak")
	public ResponseEntity<?> insertStreak(@RequestBody StreakDto streakDto) {
	    boolean streakInserted = userService.insertStreak(streakDto);
	    if (streakInserted) {
	        return new ResponseEntity<Void>(HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
}
