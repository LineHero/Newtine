package com.newtine.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.newtine.model.dto.BodyprofileDto;
import com.newtine.model.dto.MylistDto;
import com.newtine.model.dto.StreakDto;
import com.newtine.model.dto.UserDto;
import com.newtine.model.dto.UserfollowlistDto;
import com.newtine.model.dto.UserinfoforfollowDto;
import com.newtine.model.service.MypageService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/mypage")
public class MyPageController {

	private final MypageService mypageService;
	
	@Autowired
	public MyPageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}
	
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getmypagedata(HttpSession session, @PathVariable("id") int id) {
		Map<String, Object> response = new HashMap<>();
		UserDto user = mypageService.getuserbyno(id);
		List<UserfollowlistDto> myfollowlist = mypageService.getmyfollowlist(id);
		List<UserDto> followlist = new ArrayList<>();
		
		if (myfollowlist != null) {
			for (int i = 0; i < myfollowlist.size(); i++) {
				followlist.add(mypageService.getuserbyno(myfollowlist.get(i).getFollowuserNo()));
			}
		}
		
		if (user != null) {
			
			response.put("myfollowlist", followlist);
			
			response.put("loginuserid", user.getUserId());
			response.put("userthumbnail", user.getUserProfileFileId());
			List<BodyprofileDto> thisuserbodyprofile = mypageService.getmybodyprofile(user.getUserNo());
			List<StreakDto> thisuserstreak = mypageService.getmystreak(user.getUserNo());
			
			response.put("bodyprofile", thisuserbodyprofile);
			response.put("streak", thisuserstreak);
			
			List<Date> measuredate = new ArrayList<>();
			List<Double> skeletalmusclemass = new ArrayList<>();
			List<Double> musclemass = new ArrayList<>();
			List<Double> bodyfat = new ArrayList<>();
			List<Double> weight = new ArrayList<>();
			
			for (int i = 0; i < thisuserbodyprofile.size(); i++) {
				measuredate.add(thisuserbodyprofile.get(i).getMeasureDate());
				skeletalmusclemass.add(thisuserbodyprofile.get(i).getSkeletalmuscleMass());
				bodyfat.add(thisuserbodyprofile.get(i).getBodyfatPercentage());
				musclemass.add(thisuserbodyprofile.get(i).getMuscleMass());
				weight.add(thisuserbodyprofile.get(i).getWeight());
			}
			
			response.put("weight", weight);
			response.put("measuredate", measuredate);
			response.put("skeletalmusclemass", skeletalmusclemass);
			response.put("musclemass", musclemass);
			response.put("bodyfat", bodyfat);
			
			LocalDate local = LocalDate.now();
			int maxstreak = 0;
			
			for (int i = 0; i < thisuserstreak.size(); i++) {
				LocalDate cur = convertToLocalDateViaInstant(thisuserstreak.get(i).getHealthDate());
				if (local.equals(cur)) {
					maxstreak++;
					local = local.minusDays(1);
				}
			}
			response.put("maxstreak", maxstreak);
			
			List<MylistDto> mylist = mypageService.getmylistformypage(id);
			
			response.put("mylist", mylist);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
		}
	}
	
	
	@PostMapping("/thumbnail")
	public ResponseEntity<?> uploadthumbnail(@RequestParam("file") MultipartFile multipartFile, @RequestParam("userId")String userId) {
		mypageService.uploadimage(multipartFile, userId);
		
		String curimg = mypageService.getmyprofileimg(userId);
		
		return new ResponseEntity<String>(curimg, HttpStatus.OK);
	}
	
	@GetMapping("/lflist/{userId}")
	public ResponseEntity<?> getmyfollowlist(@PathVariable("userId") String userId){
		UserDto user = mypageService.getuserbyid(userId);
		
		List<UserfollowlistDto> myfollowlist = mypageService.getmyfollowlist(user.getUserNo());
		
		return new ResponseEntity<List<UserfollowlistDto>>(myfollowlist, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/follow")
	public ResponseEntity<?> unfollow(@RequestBody UserinfoforfollowDto userinfo) {
		int unfolUserno = userinfo.getUserNo();
		String loginuserId = userinfo.getUserId();
		
		UserDto loginUser = mypageService.getuserbyid(loginuserId);
		int loginUserno = loginUser.getUserNo();
		
		Map <String, Integer> unfollowing = new HashMap<>();
		
		unfollowing.put("unfolUserno", unfolUserno);
		unfollowing.put("loginUserno", loginUserno);
		
		mypageService.unfollow(unfollowing);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/follow")
	public ResponseEntity<?> dofollow(@RequestBody UserinfoforfollowDto userinfo) {
		int dofolUserno = userinfo.getUserNo();
		String loginuserId = userinfo.getUserId();
		
		UserDto loginUser = mypageService.getuserbyid(loginuserId);
		int loginUserno = loginUser.getUserNo();
		
		Map <String, Integer> dofollowing = new HashMap<>();
		
		dofollowing.put("dofolUserno", dofolUserno);
		dofollowing.put("loginUserno", loginUserno);
		
		
		mypageService.dofollow(dofollowing);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/measure")
	public ResponseEntity<?> measure(@RequestBody BodyprofileDto bodyprofile) {
		mypageService.insertbodyprofile(bodyprofile);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{listNo}")
	public ResponseEntity<?> deletemylist(@PathVariable("listNo") int listNo) {
		System.out.println(listNo);
		mypageService.deletemylist(listNo);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
