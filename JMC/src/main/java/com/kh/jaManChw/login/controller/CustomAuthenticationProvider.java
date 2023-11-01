//package com.kh.jaManChw.login.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.kh.jaManChw.dto.Users;
//import com.kh.jaManChw.login.service.face.CustomUserDetailService;
//
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider{
//
//	@Autowired
//	private CustomUserDetailService customUserDetailService; //CustomUserDetails Class Autowired.
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder; //BCryptPasswordEncoder Class Autowired.
//	
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		
//		//사용자 입력값
//		String userId = (String)authentication.getPrincipal();
//		String userPw = (String)authentication.getCredentials();
//		
//		Users users = (Users) customUserDetailService.loadUserByUsername(userId);
//	
//		if(!passwordEncoder.matches(userPw, users.getPassword())) {
//			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
//		}
//		if (users.getRole() != "user") {
//			throw new DisabledException(userId);
//		}
//				
//		List<GrantedAuthority> roles = (List<GrantedAuthority>) users.getAuthorities();
//		
//		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userId,userPw,roles);
//		return result;
//
//	}
//
//	
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return true;
//	}
//	
//	
//}
