package com.biz.shop.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.shop.domain.Authrities;
import com.biz.shop.domain.Users;
import com.biz.shop.repository.AuthDao;
import com.biz.shop.repository.UserDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service
public class AuthService {

	private final BCryptPasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final AuthDao authDao;

	
	@Transactional
	public void userSave(Users userVO) {
		
		String userRole = "ROLE_ADMIN";
		
		// 처음등록 사용자에게는 ADMIN을 부여하고 이후 사용주에게는 user를 부여하는 코드
		
		String plainPassword = userVO.getPassword();
		String cryptPassword = passwordEncoder.encode(plainPassword);
		
		userVO.setPassword(cryptPassword);
		userVO.setEnabled(true);
		
		Authrities auth = Authrities.builder().username(userVO.getUsername()).authority(userRole).build();
		
		userDao.save(userVO);
		authDao.save(auth);
		
		
	}
	
	
}
