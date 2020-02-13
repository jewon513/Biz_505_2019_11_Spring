package com.biz.crawl.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.crawl.domain.NaverMovieVO;
import com.biz.crawl.service.MovieCrawlService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping(value = "naver")
@RestController
public class NaverMovieCrawlController {

	
	private final MovieCrawlService moviceService;
	
	@RequestMapping(value = "rank", method = RequestMethod.GET)
	public List<NaverMovieVO> rank() {
		
		List<NaverMovieVO> naverList = moviceService.selectAll();
		return naverList;
	}
	
	
}
