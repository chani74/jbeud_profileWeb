package com.chani74.profile.dto;

import org.eclipse.tags.shaded.org.apache.xpath.functions.FuncCeiling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDto {
	private int total ; // 총글의 갯수
	private int startPage ; // 화면에 보여질 시작페이지 번호
	private int endPage ;  // 화면에서 보여질 마지막 페이지 번호
	private boolean next ; // 현재 보여지고 있는 페이지 번호 이상으로 페이지가 있는지
	private boolean prev ; // 형재 보여지고 있는 페이지 번호 이하로 페이지가 있는지
	
	private Criteria criteria;

	public PageDto(int total, Criteria criteria) {
		super();
		this.total = total;
		this.criteria = criteria;
		
		this.endPage = (int) ((Math.ceil(criteria.getPageNum()/10.0))*10);
		this.startPage = this.endPage - 9;
		
		int realEndPage = (int) Math.ceil(total*1.0/criteria.getAmount()); 
		
		// realEndpage가 35 / endpage가 40 이면. endPage에 realendpage를 넣어준다.
		if ( realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
	}
}
