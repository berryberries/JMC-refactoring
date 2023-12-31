//package com.kh.jaManChw.login.Handler;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//	private final Logger logger = LoggerFactory.getLogger(getClass());
//	
//	@Override
//	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException exception) throws IOException, ServletException {
//		
//		logger.error("login Failed !!");
//		response.sendRedirect("/login/main?auth=fail");
//	}
//}
