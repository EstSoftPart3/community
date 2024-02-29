package com.community.fo.jpa.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.community.fo.jpa.entity.MemberEntity;


@Repository
public interface MemberRepository  extends JpaRepository<MemberEntity, Integer>  {


	
	//모든 멤버 가져오기 
	
	
	//멤버 회원가입 
	
	
	//멤버 수정하기 
	
	//멤버 삭제하기 

}