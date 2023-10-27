package com.kh.jaManChw.login.jwt;


import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kh.jaManChw.dto.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenProvider {
	
	private final String securityKey = "this_is_jmc_login_secretkey_please_protect_sectetmessage";  // 서명에 사용할 secretKey
	private final Long exp = 1000 * 60L * 60; // 유효시간 1시간
	
	
	/**
	 *  user 정보를 담은 jwt토큰을 생성
	 * @param users
	 * @return String jwt토큰
	 */
	public String genderateJwtToken(Users users) {
		
		Date now = new Date();
		return Jwts.builder()
							// 토큰 타입
							.setHeaderParam("typ","JWT") 
							// 토큰 제목
							.setSubject("userToken") 
							// 토큰 유효시간
							.setExpiration(new Date(System.currentTimeMillis() + exp)) 
							// 토큰에 담을 데이터
							.claim("users",users) 
							//securityKey를 사용해서 해싱 암호화 알고리즘 처리
							.signWith(SignatureAlgorithm.HS256, securityKey.getBytes())
							// 직렬화,문자열로 변경
							.compact(); 	
	}
	
	/**
	 * 토큰에 담긴 정보를 가져오기
	 * @param Token
	 * @return claims.getBody()
	 * @throws Exception
	 */
	public Map<String,Object> getInfo(String token) throws Exception{
		
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(securityKey.getBytes()).parseClaimsJws(token);
		} catch (Exception e) {
			throw new Exception();
		}
		return claims.getBody();
	}
	
	/**
	 * interceptor에서 토큰 유효성을 검증하기
	 * @param token
	 */
	public void checkValid(String token) {
			Jwts.parser().setSigningKey(securityKey.getBytes()).parseClaimsJws(token);
	}

}
