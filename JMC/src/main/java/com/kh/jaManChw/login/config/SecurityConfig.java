//package com.kh.jaManChw.login.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.kh.jaManChw.dto.Users;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	//@Autowired AuthenticationSuccessHandler authenticationSuccessHandler; 
//
//	// 자원에 대한 접근제어
//	@Override
//	public void configure(WebSecurity web) throws Exception{
//		web.ignoring().antMatchers("/image/**","/js/**");
//	}
//	
//	protected void configuer(HttpSecurity http) throws Exception{
//		http
//			.csrf().disable();
//		
//		http
//			.authorizeRequests()  //인증, 인가가 필요한 URL 지정
//			.antMatchers("/mypage/**").authenticated() // 해당 URL에 진입하기 위해서 Authentication(인증, 로그인)이 필요함
//			.antMatchers("/meeting/**").authenticated()
//			.antMatchers("/chat/**").authenticated()
//			.antMatchers("/admin/**/**").hasRole("admin") // role이 admin인 사람만 접근 가능
//			.anyRequest().permitAll();
//		
//		http
//			.formLogin()
//			.usernameParameter("userId")
//			.passwordParameter("userPw")
//			.loginPage("/login/login")
//			.defaultSuccessUrl("/login/main")
//			.failureUrl("/login/login");
//		
//		http
//			.logout()
//			.logoutSuccessUrl("/login/main")
//			.invalidateHttpSession(true);
//			
//			
//	}
//}
