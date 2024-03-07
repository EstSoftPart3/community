package com.community.fo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;


import com.community.fo.jpa.entity.MemberEntity;
import com.community.fo.jpa.repository.MemberRepository;
import com.community.fo.mybatis.mapper.MemberMapper;
import com.community.fo.mybatis.vo.MemberVo;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	public MemberRepository memberRepository;
	
	@Autowired
	public BCryptPasswordEncoder  passwordEncoder;
	
	
	@Autowired
	MemberMapper memberMapper;
	
	
	// 모든 회원 검색 
	public List<MemberEntity> showAllList(){
		return memberRepository.findAll();
	}
	
	
	//회원 등록하기
	public void registerMember(MemberEntity memberEntity) {
		
		//비밀번호 암호화한 부분을 저장
		
        System.out.println(memberEntity.getPw());
        memberEntity.setPwEncryp(passwordEncoder.encode(memberEntity.getPw()));
        
        
		memberRepository.save(memberEntity);
	}
	
	//회원 삭제하기 (테스트)
	public int delMember(int mbrSq ) {
		Optional<MemberEntity> result = memberRepository.findById(mbrSq);
		
		if(result.isPresent()) {
			 memberRepository.deleteById(mbrSq);
			 return 1;
				
		}
		else {
			return 0;
		}

	}
	
	// 회원 수정하기 
	@Override
	public int updateMember(int mbrSq, MemberEntity memberEntity) {
		
		if (memberRepository.findById(mbrSq).isEmpty()) {
			memberRepository.save(memberEntity);
			return 1;
		}
		else {
			memberRepository.save(memberEntity);
			return 2;
		
	   }
   }

  
	@Override
	public  List<MemberVo> empList() {
		
	 return	memberMapper.empList();
	
	}


	// 아이디 중복 체크 
	@Override
	public int getOneMemberById(String id) {
	   int memberExist = memberMapper.getMemberById(id);
	      
	      return memberExist;
	}


	// 닉네임 중복 체크 
	@Override
	public int getOneMemberByNicknm(String nicknm) {
		Integer result =   memberMapper.getMemberByNicknm(nicknm);
	      
	    return result;
	}

 
	
}
