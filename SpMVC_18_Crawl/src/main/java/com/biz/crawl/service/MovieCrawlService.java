package com.biz.crawl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.biz.crawl.domain.NaverMovieVO;
import com.biz.crawl.persistence.NaverDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MovieCrawlService {

	/*
	 * 	네이버 현재 상형작 리스트에서 영화 제목, 이미지, 순위를 가져오기 위해서 url, title이 들어있는 tag,
	 * 																				 image가 들어있는 tag,
	 * 																				 rankList가 들어있는 tag
	 * 
	 */
	
	private final String naverMovieURL = "https://movie.naver.com/movie/running/current.nhn";
	private final String mTitleTag = "dt.tit a";
	private final String mImageTag = "div.thumb a img";
	private final String rankListTag = "dl.lst_dsc";
	
	private final NaverDao nDao;
	
	public List<NaverMovieVO> selectAll(){
		return nDao.selectAll();
	}
	
	@Scheduled(fixedDelay = 10000)
	public void naverMovieGet() {
		
		List<NaverMovieVO> naverList = this.movieRankGet();
		nDao.deleteAll();
		for(NaverMovieVO vo : naverList) {
			
			nDao.insert(vo);
			
		}
		
		
	}
	
	
	public List<NaverMovieVO> movieRankGet() {
		
		// URL에 해당하는 html 페이지코드를 가져오기
		// Document 라는 클래스에 담기
		// jsoup document 클래스를 사용하여
		// DOM 형식의 document를 만든다
		Document naverMovieDoc = null;
		
		try {
			naverMovieDoc = Jsoup.connect(this.naverMovieURL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DOM rankListTag 문자열을 기준으로 리스트를 추출
		Elements scoreList = naverMovieDoc.select(this.rankListTag);
		
		// DOM imgListTag 문자열을 기준으로 리스트를 추출
		Elements imgList = naverMovieDoc.select(this.mImageTag);
		
		// DOM titleListTag 문자열을 기준으로 리스트를 추출
		Elements titleList = naverMovieDoc.select(this.mTitleTag);
		
		
		List<NaverMovieVO> naverList = new ArrayList<>();
		
		// rankList box들 중에 상위 1부터 10번까지만 가져오기
		
		for (int i = 0; i < 10; i++) {
			
			// dt.tit a에 담긴 text를 추출하기 = 영화제목
			String title = titleList.get(i).text();
			
			// dt.tit a tag의 href 속성값을 추출 = 영화 자세히 보기
			String detailUrl = "https://movie.naver.com" + titleList.get(i).attr("href");
			
			String imgUrl = imgList.get(i).attr("src");
			naverList.add(
				NaverMovieVO.builder().m_rank(i+1).m_title(title).m_detailURL(detailUrl).m_imgURL(imgUrl).build()
			);
			
			
			
			log.debug("영화제목 : " + title);
			
			
		}
		
		return naverList;
	}
	
}
