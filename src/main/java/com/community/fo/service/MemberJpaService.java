package com.community.fo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.fo.jpa.dto.MemberResponseDto;
import com.community.fo.jpa.dto.MemberUpdateDto;
import com.community.fo.jpa.entity.MemberEntity;
import com.community.fo.jpa.repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class MemberJpaService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	// 모든 회원 검색 
	public List<MemberEntity> showAllList(){
		return memberRepository.findAll();
	}
	
	
	//회원 등록하기
	public void registerMember(MemberEntity memberEntity) {

		memberRepository.save(memberEntity);
	}
	
	//회원 삭제하기 (테스트)
	public void delMember(int mbrSq ) {
		 memberRepository.deleteById(mbrSq);
	}
	
	//회원 수정하기 

    @Transactional
    public int updateMember(int id, MemberUpdateDto memberUpdateDto){
    	 MemberEntity memberEntity = memberRepository.findMbrById(id).orElse(null);
		 memberEntity.update(memberUpdateDto.getId(),memberUpdateDto.getPw(),memberUpdateDto.getEmail(),memberUpdateDto.getNicknm(),memberUpdateDto.getName(),memberUpdateDto.getPhone(),memberUpdateDto.getAddress());
        return id;
    }

    public MemberResponseDto findMemberById(int mbrSq){
        MemberEntity memberEntity= memberRepository.findById(mbrSq).orElseThrow(() -> new IllegalArgumentException("해당 회원 존재하지 않음"));
        return new MemberResponseDto(memberEntity);
    }
}
