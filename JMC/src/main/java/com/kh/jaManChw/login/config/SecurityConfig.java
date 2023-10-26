package com.kh.jaManChw.login.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;


// @Configuration : 빈등록해준다.
// @EnableWebSecurity : 스프링 시튜리티 사용을 위한 어노테이션 , springSecurityFilterChain가 자동으로 포함
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private AuthenticationProvider authenticationProvider;
	
	public void SpringSecurityconfig(AuthenticationProvider authenticationProvider){
		
		this.authenticationProvider = authenticationProvider;
	}

	
	//스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//authenticationProvider 구현체
		auth.authenticationProvider(authenticationProvider);
	}
	
	// 스프링시큐리티 률을 무시하게 하는 url 규칙. 여기에 등록하면 규칙 적용 x
	public void configure(WebSecurity web) throws Exception{
		web.ignoring()
			.antMatchers("/resources/**")
			.antMatchers("/img/**")
			.antMatchers("/js/**")
		;
	}

	// 스프링 시큐리티 규칙
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 보호된 리소스 url에 접근할 수 있는 권한을 설정
		// permitAll() : 전체 접근 허용
		http.authorizeRequests()
		
			.antMatchers("/login/**").permitAll()
			.antMatchers("/meeting/**").permitAll()
			.antMatchers("/board/**").permitAll()
			.antMatchers("/chat/**").permitAll()
			.antMatchers("/mypage/**").permitAll()
			.antMatchers("/admit/**/**").hasRole("admin")
			.anyRequest().authenticated()
		.and().logout()
			  .logoutUrl("/login/logout")
		;
	}
	

	
	
}

