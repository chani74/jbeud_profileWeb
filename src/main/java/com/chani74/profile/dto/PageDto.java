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
	private int realEndPage ;  // 실제 마지막 페이지
	private boolean next ; // 현재 보여지고 있는 페이지 번호 이상으로 페이지가 있는지
	private boolean prev ; // 형재 보여지고 있는 페이지 번호 이하로 페이지가 있는지
	
	private Criteria criteria;

	public PageDto(int total, Criteria criteria) {
		super();
		this.total = total;
		this.criteria = criteria;
		
		// 표시될 마지막 페이지 , 첫페이지 구하기
		// 이동할 페이지를 10으로 나누고 올림 해서 10 곱하기   
		// 예) 13 페이지 => 1.3 => 2 => 20  
		this.endPage = (int) ((Math.ceil(criteria.getPageNum()/10.0))*10);
		this.startPage = this.endPage - 9;  // 첫페이지는 무조건 1, 11,21 등이므로 9를 빼면 된다.
		
		// 끝페이지가 10의 배수가 아닌 마지막 페이지인 경우 처리
		this.realEndPage = (int) Math.ceil(total*1.0/criteria.getAmount()); 
		
		// realEndpage가 35 / endpage가 40 이면. endPage에 realendpage를 넣어준다.
		if ( this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		prev = (this.startPage != 1);
		next = (this.realEndPage > this.endPage );
		
	}
}
