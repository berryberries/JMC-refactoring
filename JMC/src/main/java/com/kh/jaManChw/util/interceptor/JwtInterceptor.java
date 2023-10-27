package com.kh.jaManChw.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.jaManChw.login.jwt.JwtTokenProvider;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	@Autowired JwtTokenProvider jwtTokenProvider;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// preflight로 넘어온 options는 통과
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		} else {
			
			// client에서 요청할 때 header에 넣어둔 "jwt-auth-token"이라는 키 값을 확인
			String token = request.getHeader("jwt-auth-token");
			if(token != null && token.length() > 0) {
				
				//토큰 유효성 검증
				jwtTokenProvider.checkValid(token);
				return true;
			}else { 
				//유효한 인증토큰이 아닐경우
				throw new Exception("유효한 인증토큰이 존재하지 않습니다.");
			}
		}
	}
	
	

}
