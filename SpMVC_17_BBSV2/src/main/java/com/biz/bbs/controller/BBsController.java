package com.biz.bbs.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.BBsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes("bbsVO")
@Controller
@RequestMapping(value = "/bbs")
public class BBsController {

	@ModelAttribute("bbsVO")
	public BBsVO makeBBsVO() {
		return new BBsVO();
	}
	
	
	private final BBsService bbsService;

	@Autowired
	public BBsController(@Qualifier("bServiceV1") BBsService bbsService) {
		this.bbsService = bbsService;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET )
	public String selectAll(Model model) {
		
		List<BBsVO> bbsList = bbsService.selectAll();
		
		model.addAttribute("LIST", bbsList);
		model.addAttribute("BODY","BBS_LIST");
		
		return "home";
	}
	
	@RequestMapping(value = "input", method = RequestMethod.GET)
	public String input(Model model) {
		
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		
		BBsVO bbsVO = BBsVO.builder().bbs_date(localDate.toString()).bbs_time(localTime.format(dt)).build();
		model.addAttribute("bbsVO", bbsVO);
		model.addAttribute("BODY", "BBS_INPUT");
		
		return "home";
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public String save(Model model, BBsVO bbsVO) {

		bbsService.save(bbsVO);
		
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value = "/view" , method=RequestMethod.GET)
	public String view(Model model, long bbs_id) {
		
		BBsVO bbsVO = bbsService.findById(bbs_id);
		
		model.addAttribute("bbsVO",bbsVO);
		
		return "view";
	}
	
	@RequestMapping(value = "replay", method = RequestMethod.POST)
	public String replay(@ModelAttribute("bbsVO") BBsVO bbsVO, Model model) {
		
		log.debug("replay : " + bbsVO );
		
		bbsService.replay(bbsVO);
		
		return "redirect:/bbs/list";
	}
	
}
