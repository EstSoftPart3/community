package com.community.common.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import groovy.util.logging.Slf4j;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Slf4j
public class LoginSuccessHandler extends  SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		    PrincipalDetails userDetails = (PrincipalDetails) authentication.getPrincipal();
		    System.out.println("Authenticated user: " + userDetails.getUsername());
		    
		     // HttpSession 객체를 통해 세션 정보에 접근할 수 있습니다.
		    HttpSession session = request.getSession();
		    
		    // 세션에 사용자 정보를 저장할 수 있습니다.
		    session.setAttribute("userId", userDetails.getUsername());

		    super.clearAuthenticationAttributes(request);

		    RequestCache requestCache = new HttpSessionRequestCache();
		    SavedRequest savedRequest = requestCache.getRequest(request, response);

		    String redirectUrl = "/main"; // 기본적으로 메인 페이지로 리다이렉션합니다.
		    if (savedRequest != null) {
		        String url = savedRequest.getRedirectUrl();
		        if (url != null && !url.equals("")) {
		            redirectUrl = url;
		        }
		        requestCache.removeRequest(request, response);
		    }
		    
		    // 리다이렉션
		    getRedirectStrategy().sendRedirect(request, response, redirectUrl);
	    }

	}


