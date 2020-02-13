package com.biz.ems.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.ems.domain.EmailVO;
import com.biz.ems.service.MailService;
import com.biz.ems.service.SendMailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SessionAttributes("emailVO")
@RequestMapping(value = "/ems")
@Controller
public class EMSController {
	
	/*
	 * 	ModelAttributte 생성자 Method
	 *  Controller에 MedelAttribute 객체가 없거나 null 인 상태이면
	 *  이 method를 실행하여 emailVO를 만든다.
	 *  
	 *  하지만, 현재 상태에서 한 번이라도 이 method가 호출되어  eamilVO가 생성된 상태라면
	 *  
	 * 
	 */
	
	private final SendMailService xMailService;
	private final MailService mailService;
	
	@ModelAttribute("emailVO")
	public EmailVO makeEmailVO() {
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:dd");
		
		Date date = new Date();
		
		String curDate = sd.format(date);
		String curTime = st.format(date);
		
		EmailVO emailVO = EmailVO.builder().sendDate(curDate).sendTime(curTime).build();
		
		return emailVO; 
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model, SessionStatus status) {
		
		status.setComplete();
		
		List<EmailVO> mailList = mailService.selectAll();
		model.addAttribute("LIST",mailList);
		
		return "home";
	}
	

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(@ModelAttribute("emailVO") EmailVO emailVO, Model model, SessionStatus status) {
		
		status.setComplete();
		
		model.addAttribute("emailVO",emailVO);
		model.addAttribute("BODY","WRITE");
		
		return "home";
		
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute("emailVO") EmailVO emailVO) {
		
		log.debug("컨트롤러에서 받은 VO" + emailVO.toString());
		
//		xMailService.sendMail(emailVO);
		mailService.insert(emailVO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view(@ModelAttribute("emailVO")EmailVO emailVO, String ems_seq, Model model) {
		
		emailVO =  mailService.findBySeq(Long.valueOf(ems_seq));
		
		model.addAttribute("BODY","VIEW");
		model.addAttribute("emailVO",emailVO);
		
		
		return "home";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(@ModelAttribute("emailVO")EmailVO emailVO ,String ems_seq, Model model) {
		
		emailVO =  mailService.findBySeq(Long.valueOf(ems_seq));
		
		log.debug("업데이트 : " + emailVO.toString());
		
		model.addAttribute("BODY","WRITE");
		model.addAttribute("emailVO",emailVO);
		
		return "home";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("emailVO")EmailVO emailVO, Model model) {
		
		log.debug("업데이트 포스트 : "+ emailVO.toString());
		
		mailService.update(emailVO);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(String ems_seq) {
		
		try {
			mailService.delete(ems_seq);
			return "OK";
		} catch (Exception e) {
			// TODO: handle exception
			return "FALSE";
		}
		
	}
	
}
