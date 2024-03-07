package com.community.common.security;

import java.util.ArrayList;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.community.fo.jpa.dto.PrincipalDetails;

import com.community.fo.service.UserDetailService;

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
	
	
    UserDetailService userDetailsService;
    BCryptPasswordEncoder passwordEncoder;
    
    public CustomAuthenticationProvider(UserDetailService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }
   
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		 
		
		    String id = authentication.getName();
	        String password =  (String)authentication.getCredentials();
	        
	        PrincipalDetails user = (PrincipalDetails ) userDetailsService.loadUserByUsername(id);

	       
	        if(!passwordEncoder.matches(password, user.getPassword())) {
				throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
			}
	        List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			//롤을 지정 
			
			return new UsernamePasswordAuthenticationToken(id,password,authorities);
			//계정이 인증됐다면 UsernamePasswordAuthenticationToken 객체에 화면에서 입력한 정보와 DB에서 가져온 권한을 담아서 리턴한다.
			
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	

    


}
