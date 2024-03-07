package com.community.common.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import groovy.util.logging.Slf4j;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Slf4j
public class LoginSuccessHandler extends  SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		    super.clearAuthenticationAttributes(request);

	        RequestCache requestCache = new HttpSessionRequestCache();
	        SavedRequest savedRequest = requestCache.getRequest(request, response);

	        if(savedRequest != null){
	            String url = savedRequest.getRedirectUrl();
	            if(url == null || url.equals("")){
	                url = "/";
	            }
	            if(url.contains("/register")){
	                url = "/";
	            }
	            if(url.contains("/login")){
	                url = "/";
	            }
	            requestCache.removeRequest(request, response);
	            getRedirectStrategy().sendRedirect(request, response, url);
	        }
	        super.onAuthenticationSuccess(request, response, authentication);
	    }

	}


