package com.biz.bbs.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.domain.CommentVO;
import com.biz.bbs.service.BBsService;
import com.biz.bbs.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes("bbsVO")
@RequestMapping(value="/bbs")
@Controller
public class BBsController {
	
	private final CommentService cmmService;
	private final BBsService bService;

	@Autowired	
	public BBsController(@Qualifier("bServcieV1") BBsService bService, CommentService cmmService) {
		super();
		this.bService = bService;
		this.cmmService = cmmService;
	}
	
	@ModelAttribute("bbsVO")
	public BBsVO makeBBsVO() {
		return new BBsVO();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String selectAll(Model model) {
		
		List<BBsVO> bbsList = bService.selectAll();
		model.addAttribute("BBS_LIST",bbsList);
		model.addAttribute("BODY","BBS_LIST");
		
		return "home";
		
	}
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input(Model model) {

		// java 1.8 이상의 새로운 날짜 시간 클래스
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		BBsVO bbsVO = BBsVO.builder()
						.bbs_date(ld.toString())
						.bbs_time(lt.format(dt))
						.build();
		
		model.addAttribute("bbsVO",bbsVO);
		model.addAttribute("BODY","BBS_INPUT");
		return "home";
		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("bbsVO") BBsVO bbsVO) {
		
		bService.save(bbsVO);
		return "redirect:/bbs/list";
	
	}
	
	/*
	 * view method에서 @ModelAttribute를 사용하는 이유
	 * 게시판 상세페이지에서 답글을 작성할때 본문만 작성하는 textArea box를 두고 나머지 항목들을 별도로 저장하거나 하지 않아도
	 * 답글을 저장하였을때 원글의 내용이 같이 controller로 전송되도록 하기 위함이다.
	 * 
	 * @ModelAttribute로 설정된 bbsVO는 sessionAttributes에 설정이 되어 있기 때문에 model.addAttribute로 만드는 순간 서버 session에 저장되어 있어서
	 * 다른 method에서 그 값을 참조할 수 있다.
	 */
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(@ModelAttribute("bbsVO") BBsVO bbsVO, Model model) {
		
		bbsVO = bService.findById(bbsVO.getBbs_id());
		
		//bbsVO.setBbs_writer("");
		
		model.addAttribute("bbsVO",bbsVO);
		model.addAttribute("BODY","BBS_VIEW");
		return "home";
		
	}
	
	@RequestMapping(value="/replay",method=RequestMethod.POST)
	public String replay(@ModelAttribute("bbsVO") BBsVO bbsVO) {

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter ld = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter lt = DateTimeFormatter.ofPattern("HH-mm-ss");
		bbsVO.setBbs_date(ldt.format(ld));
		bbsVO.setBbs_time(ldt.format(lt));
		
		bbsVO = bService.replay(bbsVO);
		return "redirect:/bbs/list";
		
	}
	
	@RequestMapping(value = "/cmt_list", method = RequestMethod.GET)
	public String cmt_list(Model model, long cmt_p_id) {
		
		List<CommentVO> cmmList = cmmService.selectAll(cmt_p_id);
		
		model.addAttribute("CMT_LIST",cmmList);
		
		return "include/bbs-comment";
	}
	
	
	@RequestMapping(value = "/cmt_write", method = RequestMethod.POST)
	public String comment(CommentVO cmmVO, Model model) {
		
		log.debug("코멘트 커멘드 : " +  cmmVO.toString());
		
		int ret = cmmService.insert(cmmVO);
		
		List<CommentVO> cmmList = cmmService.selectAll(cmmVO.getCmt_p_id());
		
		model.addAttribute("CMT_LIST",cmmList);
		
		return "include/bbs-comment";
	}
	
	
	
	
}
