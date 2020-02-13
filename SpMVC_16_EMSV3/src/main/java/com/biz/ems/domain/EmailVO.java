package com.biz.ems.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder


/*
 *	@Entity : import javax.persistence.Entity
 *	-JPA interface에 정의된 속성을 지정
 *	-지금부터 이 Class는 Entity이니 물리적 Table과 연동되도록 준비하라 라고 알리는 기능
 *
 * 	-속성중에 다음 항목이 지정이 되어 있다면
 * 		<prop key="hibernate.hbm2ddl.auto">create</prop>
 * 	 Entity에 지정된 속성에 따라 Table을 생성하라
 *   create value : drop and create 
 *   지정하지 않는다면 기본 값이 create이다. 실무에서는 update로 지정한다.
 *   update로 지정을 하게 되면 Table이 없으면 생성을 하고 만약 물리적 Table과 구조가 다르면 오류가 발생한다.
 * 	
 * 
 * 	 주의
 * 		만약 hiberante.hbm2ddl.auto 속성을 지정하지 않으면 default value가 create이므로 기존의 테이블을 drop하고 새로 create하기 때문에
 * 		데이터가 삭제될 수 있다. 따라서 반드시 update로 지정을 해준다.
 * 
 * 	 none : 기본값, 아무일도 하지 않는다.
 * 	 create-only : 테이블을 새로 생성
 * 	 drop : 삭제
 *   create : drop and create
 *   create-drop : 시작할때 drop and create를 하고 session이 끝나면 다시 drop한다.
 *   validate : 검증만 하고
 *   update : schema를 갱신, 없으면 만들고 있으면 validate를 한다.
 */

@Entity
@Table(name = "tbl_ems", schema = "emsDB")
public class EmailVO {

	// 보내는 Email
	// 받는 Email
	// 보내는 사람
	// 받는 사람
	// 제목
	// 내용
	// 작성일자
	// 작성시각
	
	
	/*
	 *  필드 변수에 @ID , @Column 속성을 지정하면 테이블의 칼럼으로 생성을 한다.
	 *  @ID는 PRIMARY KEY COLUMN으로 생성을 한다.
	 *  @GeneratedValue(strategy = GenerationTpye.AUTO로 설정을 해두면 auto_increment를 수행하여 insert할 떄 자동 값 채우기가 된다.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "ems_seq")
	private long ems_seq;
	
	
	/*
	 *  @Column() 지정하는 속성
	 *  nullable : not null 과 연관
	 *  nullable = false : not null 설정
	 *  nullable = true : default null 설정
	 *  length : 칼럼의 길이, 지정하지 않는다면 DB의 default value 로 255로 설정된다.
	 *  칼럼을 생성할때는 필드 변수의 이름과 같이 생성
	 */
	
	@Column(name ="from_email",nullable = false, length = 125)
	private String from_email;
	
	/*
	 * @Column(name="to_email")
	 * 필드변수와 칼럼의 이름을 달리 설정하고자 할 떄
	 */
	@Column(nullable = false, name = "to_email", length = 125)
	private String to_email;
	
	/*
	 *  columDefinition =""
	 *  칼럼의 type을 DB의 고유한 type으로 강제 적용
	 */
	@Column(nullable = true, name = "from_name", length = 125)
	@Nationalized // 문자열 칼럼 type을 locale typedp 따라 변경, 우리는 지금 kor로 설정해놨기때문에 nVarchar로 설정될 것이다. 아마도....
	private String from_name;
	
	@Column(nullable = true, columnDefinition = "nVARCHAR(20)")
	private String to_name;
	
	@Column(nullable = false, length = 255)
	@Nationalized
	private String subject;
	
	@Column(nullable = true, length = 1000)
	@Nationalized
	private String content;
	
	@Column(name="send_date", nullable = true)
	private String send_date;
	
	@Column(name="send_time", nullable = true)
	private String send_time;
	
}
