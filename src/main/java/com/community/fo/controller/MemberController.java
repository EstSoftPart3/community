package com.community.fo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.community.common.security.PrincipalDetails;
import com.community.common.security.UserDetailService;
import com.community.fo.jpa.entity.MemberEntity;
import com.community.fo.mybatis.vo.MemberVo;
import com.community.fo.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	// 서비스 인스턴스 주입을 위해 사용하는 어노테이션 
	@Autowired
	private MemberService memberService;
	
	private UserDetailService userService;
	
	// 화원가입 페이지
	@GetMapping("/register")
	public String goRegister(Model model) {

		return "pages/fo/register";
	}

	/*
	 * // 로그인 페이지
	 * 
	 * @GetMapping("/loginPage") public String goLogin(Model model) {
	 * 
	 * return "pages/fo/login";
	 */
	
	
	// 메인 페이지 
	@GetMapping("/main")
	public String goMain(Model model,HttpSession session) {
		
		// 세션에 저장된 사용자 아이디와 인증 상태를 Thymeleaf에 전달
	    model.addAttribute("authenticated", session.getAttribute("authenticated"));
	     
		return "pages/fo/main";
	}
	
	// 약관 동의 페이지
	@GetMapping("/agree")
	public String agreePage(Model model) {

		return "pages/fo/agreement";
	}
	
	// 비밀번호 찾기 페이지
	@GetMapping("/findPw")
	public String findPwPage(Model model) {

		return "pages/fo/findPwPage";
	}
	
	// 회원가져오기 
	@GetMapping("/showAllMember")
	public List<MemberEntity> showAllmember() {
		
		List<MemberEntity> memberList = memberService.showAllList();
		return memberList;		
	}
	
	// 아이디 중복 채크 
	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("id") String id){
		
		//System.out.println("param" + id);
		
		int result = memberService.getOneMemberById(id);
		
		
		System.out.println("id값:" +result);
		
		return result;
	
	}
	
	// 닉네임 중복 체크
	@PostMapping("/nicknmCheck")
	@ResponseBody
	public int nickNmCheck(@RequestParam("nicknm") String nicknm){
		
		int result = memberService.getOneMemberByNicknm(nicknm);
		System.out.println(result);
		
		return result;
		
	}


	
	//회원 등록하기
	@PostMapping("/registerMember")
	public String registerMember(MemberEntity memberEntity) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberEntity.setPwEncryp(passwordEncoder.encode(memberEntity.getPw()));

		memberService.registerMember(memberEntity);
		
		return "redirect:/login";
		
	}
	
	
	//회원 삭제하기 
	@GetMapping("/delMember/{mbrSq}")
	public String delete(@PathVariable int mbrSq) {

		int result = memberService.delMember(mbrSq);
		
		if(result == 1 ) {
			return "삭제 성공"; 
		}
		else {
			return "삭제 실패";
		}
	
	}
	
	
	//회원 수정하기 
	@PostMapping("/updateMember/{mbrSq}")
	public String updateMember(@PathVariable int mbrSq, MemberEntity memberEntity) {
		
       int  result =  memberService.updateMember(mbrSq, memberEntity);
        
        if(result == 1) {
        	return "등록 회원 없음";
        }
        else {
        	return "회원 수정 완료";
        	
        }
        
	}
	
	 //로그인 기능
	@GetMapping("/login")
    public String login(@RequestParam(required = false) boolean hasMessage,
    		            @RequestParam(required = false) String message,
			            HttpServletRequest request,
			            Model model) {
		
		model.addAttribute("hasMessage", hasMessage);
		
		
		return "pages/fo/login";
    }
	
	//로그아웃 기능
	@GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

	
	
	
	// mybatis member List 뿌리기
	// 회원가져오기 
	@GetMapping("/showMember")
	public List<MemberVo> showMember() {
		
		List<MemberVo> memberList = memberService.empList();
		return memberList;		
	}





}
