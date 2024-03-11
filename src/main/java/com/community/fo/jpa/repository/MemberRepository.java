package com.community.fo.jpa.repository;


import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.community.common.security.PrincipalDetails;
import com.community.fo.jpa.entity.MemberEntity;



@Repository
public interface MemberRepository  extends JpaRepository<MemberEntity, Integer>  {

	
	/*
	 * 사용자 정보를 조회하는 repository 
	 * string param으로 가져오는 메소드가 jpa에 없어서 @query어노테이션을 사용해서 쿼리문 작성
	 * 쿼리 작성시 from table name 이 아니라 entity name 으로 해줘야 함 
	 */
	
	
	
	@Query("SELECT m FROM MemberEntity m WHERE m.id = :userId")
	MemberEntity findByUserId(@Param("userId") String userId);

}