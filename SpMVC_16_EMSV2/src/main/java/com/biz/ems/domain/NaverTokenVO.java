package com.biz.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class NaverTokenVO {

	private String token_type;
	private int expires_in;			// 유효기간
	
	private String access_token;	// 네이버로부터 발급받은 token
	private String refresh_token;	// (선택) 네이버에 token을 재발급 요청했을때 받은 token
	
	private String error;			// (선택) 오류가 발생 했을때
	private String error_description;
	
	
	
	
}
