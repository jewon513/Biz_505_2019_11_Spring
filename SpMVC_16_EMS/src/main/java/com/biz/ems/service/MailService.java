package com.biz.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.ems.domain.EmailVO;
import com.biz.ems.repository.EmailDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MailService {

	private final EmailDao emsDao;
	
	public int insert(EmailVO emailVO) {
		
		// primary key가 vo에 담겨있으면 update, 아니면 insert 수행
		emsDao.save(emailVO);
		
		return 0;
	}
	
	public List<EmailVO> selectAll(){
		
		List<EmailVO> mailList = (List<EmailVO>) emsDao.findAll();
		
		return mailList;
	}
	
	public EmailVO findBySeq(long ems_seq) {
	
		EmailVO emailVO = emsDao.findByEmsSeq(ems_seq);
		
		return emailVO;
		
	}

	public void delete(String ems_seq) {

		emsDao.deleteById(Long.valueOf(ems_seq));
		
	}

	public void update(EmailVO emailVO) {

		emsDao.save(emailVO);
		
	}
	
	
	
	
}
