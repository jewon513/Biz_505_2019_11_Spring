package com.biz.ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ems.domain.NaverMemberVO;
import com.biz.ems.domain.NaverReturnAuth;
import com.biz.ems.domain.NaverTokenVO;
import com.biz.ems.service.NaverLoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "member")
@Controller
public class MemberController {

	private final NaverLoginService naverLoginService;
	
	@RequestMapping(value = "naver", method = RequestMethod.GET)
	public String naverLogin() {
		
		String apiURL = naverLoginService.oAuthLoginGet();
		
		return "redirect:" + apiURL;
		
	}
	
	/*
	 *  네이버에 로그인 요청을 보낼 때 네이버가 return할 url 부분이고
	 * 	외부에서 접속할 수 있는 url 이어야 한다.
	 * 
	 * 	네이버에 로그인이 성공하면 실제로 네이버에서 로그인 인증 정보를 보내준다.
	 */

	@RequestMapping(value = "/naver/ok", method = RequestMethod.GET)
	public String naver_ok(@ModelAttribute NaverReturnAuth naverLoginOK, HttpSession httpSession) {
		
		NaverTokenVO nTokenVO = naverLoginService.oAuthAccessGetToken(naverLoginOK);
		NaverMemberVO naverMemberVO = naverLoginService.getNaverMemberInfo(nTokenVO);
		
		httpSession.setAttribute("MEMBER", naverMemberVO);
		
		return "redirect:/ems/list";
		
	}
	
}
