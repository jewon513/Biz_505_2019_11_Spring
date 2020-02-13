package com.biz.ems.config;

public class NAVER {
	
	public static class TOKEN {

		public final static String grant_type = "grant_type";		// 인증 과정에 대한 구분값
		public final static String client_id = "client_id";		// 애플리케이션 등록 시 발급받은 Client Id 값
		public final static String client_secret = "client_secret";	// 애플리케이션 등록 시 발급받은 Client secret 값
		public final static String code = "code";			// 로그인 인증 요청 API 호출에 성공하고 리턴받은 인증코드값
		public final static String state = "state";			// 사이트 간 요청 위조 공격을 방지하기 위해 애플리케이션에서 생성한 상태 토큰값으로 URL 인코딩을 적용한 값을 사용
		public final static String refresh_token = "refresh_token";	// 네이버 사용자 인증에 성공하고 발급받은 갱신 토큰
		public final static String access_token = "access_token";	// 기 발급받은 접근 토큰으로 URL 인코딩을 적용한 값을 사용
		public final static String service_provider = "service_provider";// 인증 제공자 이름으로 'NAVER'로 세팅해 전송
	
	}
	
	public static class GRANT_TYPE{
		
		public final static String authorization_code = "authorization_code";	// 발급
		public final static String refresh_token = "refresh_token";				// 갱신
		public final static String delete = "delete";							// 삭제
		
	}
}
