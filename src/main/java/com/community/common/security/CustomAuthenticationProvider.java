package com.community.common.security;

import java.util.ArrayList;


import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

	/*
	 * -- 사용자가 입력한 아이디 비번의 정보와 DB에 저장된 사용자 정보를 비교해주는 인터페이스 
	 * 오버라이드되는 authenticate() 메서드는 화면에서 사용자가 입력한 로그인 정보를 담고 있는 Authentication 객체를 가지고 있다 
	 * DB에서 사용자의 정보를 가져오는 건 UserDetailsService 인터페이스에서 loadUserByUsername() 메서드로 구현
	 * 인터페이스는 인증에 성공하면 인증된 Authentication 객체를 생성하여 리턴하기 때문에 비밀번호, 계정 활성화, 잠금 모든 부분에서 확인이 되었다면 리턴
	 */
	
	
	    private final UserDetailService userDetailService;
	    private final BCryptPasswordEncoder passwordEncoder;

	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        String id = authentication.getName();
	        String password = (String) authentication.getCredentials();
	        
	        System.out.println("회원입력" + password);

	        try {
	            UserDetails userDetails = userDetailService.loadUserByUsername(id);

	            // 사용자가 입력한 비밀번호와 DB에 저장된 비밀번호를 비교하여 일치하는지 확인
	            boolean passwordMatch = passwordEncoder.matches(password, userDetails.getPassword());

	            if (!passwordMatch) {
	                throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
	            }

	            List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());

	            return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
	        } catch (UsernameNotFoundException e) {
	            throw new BadCredentialsException("사용자를 찾을 수 없습니다.");
	        }
	    }
	     @Override
	     public boolean supports(Class<?> authentication) {
	         return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	     }
    


}
