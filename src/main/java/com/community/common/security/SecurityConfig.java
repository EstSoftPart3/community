package com.community.common.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import com.community.fo.service.UserDetailService;

import lombok.AllArgsConstructor;

@Configuration  // Bean으로 사용하겠다는 어노테이션
@EnableWebSecurity // Security를 사용하겠다는 어노테이션 
public class SecurityConfig  {
        private UserDetailService userService;
		
        
            // Spring의 보안 Filter를 결정하는데 사용되는 Filter
			@Bean
			public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
				http
					.csrf((csrfConfig) ->
							csrfConfig.disable()   //html 공격 막기 위한 csrf 비활성화
					) 
					.headers((headerConfig) ->  //h2 콘솔 사용 위함
							headerConfig.frameOptions(frameOptionsConfig ->
									frameOptionsConfig.disable()
							)
					)
					.authorizeHttpRequests((authorizeRequests) ->
							authorizeRequests
							        .requestMatchers("/css/**", "/images/**", "/js/**").permitAll() // 인증하지 않은 필요 자원들 허용가능 
									.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() //  정적 자원 접근 허용
						            .anyRequest().permitAll() // 인증하지 않은 모든 URL 허용 
					)
					
					.formLogin((formLogin) ->
							formLogin // form 방식 로그인 사용
									.loginPage("/login")  // login이 진행되는 페이지
									.loginProcessingUrl("/login") //로그인 진행 중인 URL --> form 태그와 일치 해야 작동
									.defaultSuccessUrl("/main") // 로그인 성공 시 리다이렉트 하는 페이지 
									.failureHandler(new LoginFailHandler()) // 로그인 실패 시 실행되는 핸들러 
              
					)
					.logout((logoutConfig) ->
							logoutConfig.logoutSuccessUrl("/main") // 로그아웃 시 메인 페이지로 이동 
					);
  
				return http.build();
			}
			
		
			
			// 비밀번호 암호화 기능
			// controller에 빈으로 등록된 BCryptPasswordEncoder를 자동 주입을 해줍니다.
			 
		    @Bean
		    public BCryptPasswordEncoder encodePassword() {
		        return new BCryptPasswordEncoder();
		    }

}
