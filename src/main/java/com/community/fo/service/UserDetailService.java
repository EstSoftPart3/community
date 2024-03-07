package com.community.fo.service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.community.fo.jpa.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor


public class UserDetailService implements UserDetailsService {
	
	/*
	 * 시큐리티 설정에서 loginProcessingUrl("/login")으로 요청이 오면 자동으로 UserDetailsService 실행
	 * 해당 메서드내에서 DB에 저장된 정보를 불러와, User 객체에 값을 넣고 return
	 */

	
	private  MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		
		UserDetails  userDetails  = memberRepo.findById(id);
		
		System.out.println(userDetails);
		 
		 if(userDetails != null) {
			
			 return userDetails;
		 } else {
				throw new UsernameNotFoundException("can not find User : " + id);
			}
        }
	}


