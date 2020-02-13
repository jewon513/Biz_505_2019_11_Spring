package com.biz.crawl.domain;

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

public class NaverMovieVO {

	private long id;
	private int m_rank;
	private String m_title;
	private String m_detailURL;
	private String m_imgURL;
	
}
