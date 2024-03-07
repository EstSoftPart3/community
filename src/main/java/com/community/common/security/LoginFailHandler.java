package com.community.common.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		    String message = getMessage(exception);
	        String redirectUrl = "/login?hasMessage=true&message=" + message;
	        setDefaultFailureUrl(redirectUrl);
	        super.onAuthenticationFailure(request, response, exception);
		
	}
	
	 private static String getMessage(AuthenticationException exception) throws UnsupportedEncodingException {
	        String message = exception.getMessage();
	        String encodeMessage = URLEncoder.encode(message, "UTF-8");
	        return encodeMessage;
	    }
	 
	 //메소드 스펙을 봅시다. onAuthenticationFailure 메소드는 파라미터로 AuthenticationException을 받습니다. 이것이 제가 LoginCheckFailException을 AuthenticationException으로 상속받은 이유입니다. AuthenticationException만 로그인 실패 핸들러를 통해 예외 처리를 할 수 있기 때문입니다.

}
