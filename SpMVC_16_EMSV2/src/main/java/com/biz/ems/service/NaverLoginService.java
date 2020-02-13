package com.biz.ems.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.SecureRandom;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.biz.ems.config.NAVER;
import com.biz.ems.domain.NaverMemberResponseVO;
import com.biz.ems.domain.NaverMemberVO;
import com.biz.ems.domain.NaverReturnAuth;
import com.biz.ems.domain.NaverTokenVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class NaverLoginService {

	private final String loginAPI_URL = "https://nid.naver.com/oauth2.0/authorize";
	private final String tokenAPI_URL = "https://nid.naver.com/oauth2.0/token";
	private final String naverMemberAPI_URL = "https://openapi.naver.com/v1/nid/me";
	
	private final String clientId = "YFb4QKHLMQX9KrzlWXDQ";
	private final String clientSec = "NYBsIok35e";
	private final String callBackURL = "https://callor.com:12600/ems_jewon513/member/naver/ok";
	
	public String oAuthLoginGet() {
	
		String redirectURI = null;
		try {
			redirectURI = URLEncoder.encode(callBackURL,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SecureRandom random = new SecureRandom();
		
		// 최대값 130bit 크기 임의의 정수를 생성하여 문자열로 만들어라
		String stateKey = new BigInteger(130,random).toString();
		
		String apiURL = this.loginAPI_URL;
		apiURL += "?client_id=" + this.clientId;
		apiURL += "&response_type=code";
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + stateKey;
		
		return apiURL;
	}
	
	/**
	 * 네이버에 정보요구를 할 때 사용할 Token을 요청하는 method
	 * 
	 * Token을 요청할때 GET/POST method를 사용 할 수 있는데 여기서는 POST를 사용해서 요청을 하겠다.
	 * 
	 *  
	 * @param naverOK
	 */
	public NaverTokenVO oAuthAccessGetToken(NaverReturnAuth naverOK) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", this.clientId);
		headers.set("X-Naver-Client-Secret", this.clientSec);
		
		// Http에서 사용할 수 있도록 내부 로직이 변경된 Map, 기존의 Map과 사용법은 동일하다.
		/*
		 * Map interface를 상속받아 작성된 spring Framework 전용 Map 인터페이스
		 * Http protocol과 관련된 곳에서 기본 Map 대신 사용하는 인터페이스
		 * http porotocol과 관련된 내장 method가 포함되어 있다.
		 * 
		 */
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(); 
		
		params.add(NAVER.TOKEN.grant_type, NAVER.GRANT_TYPE.authorization_code);
		params.add(NAVER.TOKEN.client_id, this.clientId);
		params.add(NAVER.TOKEN.client_secret, this.clientSec);
		params.add(NAVER.TOKEN.code, naverOK.getCode());
		params.add(NAVER.TOKEN.state, naverOK.getState());
		
		// headers 에 담긴 정보와 params에 담긴 정보를 HttpEntity 데이터로 변환
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params, headers);
	
		URI restURI = null;
		
		try {
			restURI = new URI(tokenAPI_URL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * 	RestTemplet을 사용하여 네이버에 token을 요청
		 * 
		 */
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<NaverTokenVO> result = null;
		
		result = restTemp.exchange(restURI, HttpMethod.POST, request,NaverTokenVO.class);
		
		
		log.debug("Naver TOKEN : " + result.getBody().toString() );
		
		return result.getBody();
		
		
	}
	
	public NaverMemberVO getNaverMemberInfo(NaverTokenVO tokenVO) {
		
		String token = tokenVO.getAccess_token();
		String header = "bearer " + token;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", header);
		
		HttpEntity<String> request = new HttpEntity<String>("parameter",headers);
		
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<NaverMemberResponseVO> result = null;
		
		result = restTemp.exchange(naverMemberAPI_URL, HttpMethod.GET, request, NaverMemberResponseVO.class);
		
		NaverMemberVO memberVO = result.getBody().getResponse();
		
		return memberVO;
	}
	
}










