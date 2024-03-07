package com.community.fo.jpa.dto;

import java.util.ArrayList;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import com.community.fo.jpa.entity.MemberEntity;

import lombok.Data;
//
//세션의 키 값은 Security ContextHolder이고 값은 Authentication 타입의 객체
//Authentication 타입 객체에는 User 정보가 담겨 있어야 하는데 그 User정보는 UserDetails 타입 객체

@Data
public class PrincipalDetails  implements UserDetails {
	
	MemberEntity memberEntity;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pw;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_"+memberEntity.getRole();}); //add에 들어올 파라미터는 GrantedAuthority밖에 없으니 
		
		return collectors;
	}
	@Override
	public String getPassword() {
		return this.pw;
	}
	@Override
	public String getUsername() {
		return this.id;
	}
	
	//계정이 만료되지 않았는지 리턴한다. ( true : 만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	
	//계정이 감져있지 않았는지 리턴한다. ( true : 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
        return true;
    }
	
	//비밀번호가 만료되지 않았는지 리턴한다. ( true : 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	
	//계정 활성화(사용가능)인지 리턴한다. ( true : 활성화)
	@Override
	public boolean isEnabled() {
		
		return true;
	}


}
