package com.community.common.security;



import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 여기에서 로그인 여부를 확인하고, 로그인되어 있지 않으면 로그인 페이지로 리다이렉트하도록 작성
        // 예를 들어, Spring Security를 사용하고 있다면, SecurityContextHolder 등을 활용하여 로그인 여부를 확인할 수 있습니다.
        
        PrincipalDetails principal = (PrincipalDetails) request.getUserPrincipal();

        if (principal == null) {
            response.sendRedirect("/login");
            return false; // 요청을 처리하지 않도록 false 반환
        }

        // 로그인되어 있다면 계속 진행
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // Controller가 실행된 후 호출되는 메서드
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // View가 렌더링 된 후 호출되는 메서드
    }
}
