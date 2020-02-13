package com.biz.ems.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biz.ems.domain.EmailVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SendMailService {

	private final JavaMailSender xMail;
	
	public void sendMail(EmailVO emailVO) {
		
		log.debug("서비스에서 emailVO" + emailVO.toString());
		
		String from_Email = emailVO.getFromEmail();
		String to_Email = emailVO.getTo_email();

		String from_name = emailVO.getFromName();
		String to_name = emailVO.getTo_name();
		
		// mail을 보내기 위한 smtp 객체
		// mail 메세지를 담을 객체
		MimeMessage message = xMail.createMimeMessage();
		
		// mail을 보내는데 도와줄 보조 객체
		MimeMessageHelper mHelper = null;
		
		try {
			// message : 보낼 제목과 본문을 담을 객체
			// false : 순수하게 text만 보내겠다 = > true로 보내면 파일을 첨부하여 보낼 수 있다.
			// UTF-8 : 문자열 인코딩을 설정
			mHelper = new MimeMessageHelper(message,false,"UTF-8");
			mHelper.setFrom(from_Email, from_name);
			mHelper.setTo(to_Email);
			
			mHelper.setSubject(emailVO.getSubject());
			
			// setText() 2번쨰를 true로 설정하면
			// HTML tag를 반영하는 본문이 발송
			mHelper.setText(emailVO.getContent(),true);
			
			xMail.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
