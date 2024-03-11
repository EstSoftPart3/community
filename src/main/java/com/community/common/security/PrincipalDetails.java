package com.community.common.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.community.fo.jpa.entity.MemberEntity;

import lombok.Data;

import java.util.Collection;
import java.util.Collections;

@Data
public class PrincipalDetails implements UserDetails {

    private MemberEntity memberEntity;

    private static final long serialVersionUID = 1L;

    // MemberEntity를 받아서 PrincipalDetails 객체를 생성하는 생성자 추가
    public PrincipalDetails(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }
    
    public PrincipalDetails(String id, String name, String pw) {
        this.id = id;
        this.name = name;
        this.pw = pw;
    }
    
    public PrincipalDetails() {
        // 기본 생성자 구현
    }

    private String id;
    private String name;
    private String pw;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + memberEntity.getRole().name());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return memberEntity.getPwEncryp();
    }

    @Override
    public String getUsername() {
        return memberEntity.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
