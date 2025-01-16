package com.chani74.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Criteria {
	private int  amount = 10 ;//한페이지당 보여질 글의 개수 10개
	private int pageNum = 1; // 사용자가 클릭한 페이지 저장 변수
	private int startNum ; //사용자가 선택한 페이지에서 시작할 글 번호
}
