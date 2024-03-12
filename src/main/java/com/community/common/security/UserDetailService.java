package com.community.common.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.community.fo.jpa.entity.MemberEntity;
import com.community.fo.jpa.repository.MemberRepository;




@Service
public class UserDetailService implements UserDetailsService {
	
	/*
	 * 시큐리티 설정에서 loginProcessingUrl("/login")으로 요청이 오면 자동으로 UserDetailsService 실행
	 * 해당 메서드내에서 DB에 저장된 정보를 불러와, User 객체에 값을 넣고 return
	 */

	@Autowired
	private  MemberRepository memberRepo;
	
	@Override
	public PrincipalDetails  loadUserByUsername(String id) throws UsernameNotFoundException {
		
		
		  MemberEntity memberEntity = memberRepo.findByUserId(id); // 사용자 정보를 데이터베이스에서 가져옴

		    if (memberEntity != null)

		    	
				return new PrincipalDetails(memberEntity); // 사용자 정보를 PrincipalDetails 객체에 담아서 반환
			else {
		        throw new UsernameNotFoundException("User not found with id: " + id);
		    }
		    
  }  
}