package com.biz.shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 	 spring security에서 사용하는 권한 정보가 담기는 테이블, 한사람의 username에 대하여 복수의 권한을 부여할 수 있다.
 *	 authority column의 문자열을 참조하여 expression을 사용한 세부적인 권한 부여를 수행할 수 있다.
 *
 *	admin, user, manager 등등의 문자열을 저장하고 hasRole('ADMIN'), 형식으로 로그인된 사용자의 권한을 참조할 수 있다.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "authorities", schema = "emsDB")
public class Authrities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	private String username;
	private String authority;
	
}
