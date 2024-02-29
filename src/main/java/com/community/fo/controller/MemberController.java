package com.community.fo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.community.fo.jpa.dto.MemberResponseDto;
import com.community.fo.jpa.dto.MemberUpdateDto;
import com.community.fo.jpa.entity.MemberEntity;
import com.community.fo.service.MemberJpaService;

import jakarta.transaction.Transactional;

@RestController
public class MemberController {
	
	// 서비스 인스턴스 주입을 위해 사용하는 어노테이션 
	@Autowired
	private MemberJpaService memberJpaService;
	
	
	
	// 회원가져오기 
	@GetMapping("/showAllMember")
	public List<MemberEntity> showAllmember() {
		
		List<MemberEntity> memberList = memberJpaService.showAllList();
		return memberList;		
	}

	//회원 등록하기
	
	@PostMapping("/registerMember")
	public List<MemberEntity> registerMember(MemberEntity memberEntity) {
		
		memberJpaService.registerMember(memberEntity);
		List<MemberEntity> memberList = memberJpaService.showAllList();
		return memberList;
		
	}
	

	//회원 삭제하기 
	@GetMapping("/delMember/{mbrSq}")
	public List<MemberEntity> delete(@PathVariable int mbrSq) {

		memberJpaService.delMember(mbrSq);
		List<MemberEntity> memberList = memberJpaService.showAllList();

		return memberList;
	}
	
	
	//회원 수정하기 
	
	@PostMapping("/updateMember/{id}")
	public List<MemberEntity> updateMember(@PathVariable int id,
                                            @RequestBody MemberUpdateDto memberUpdateDto) {
		
         memberJpaService.updateMember(id, memberUpdateDto);
         List<MemberEntity> memberList = memberJpaService.showAllList();

 		return memberList;
		
	}
	
	 @GetMapping("/searchById/{id}")
	    public MemberResponseDto findById(@PathVariable int id){
	    }
	

}
