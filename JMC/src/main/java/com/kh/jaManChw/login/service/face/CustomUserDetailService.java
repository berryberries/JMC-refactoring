//package com.kh.jaManChw.login.service.face;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.kh.jaManChw.dto.Users;
//import com.kh.jaManChw.login.dao.face.UsersDao;
//
//public class CustomUserDetailService implements UserDetailsService {
//	
//	@Autowired UsersDao usersDao;
//	
//	@Override
//	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
//		
//		Users users = usersDao.selectUserByUserId(userId);
//		
//		if(users == null) {
//			 throw new UsernameNotFoundException("No user found with username" +users.getUserId());
//		}
//		
//          return users;
//	}
//
//}
