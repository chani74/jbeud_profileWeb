package com.chani74.profile.dao;

import com.chani74.profile.dto.MemberDto;

public interface MemberDao {
	public int joinMemberDao(String mid, String mpw, String mname, String memail);
	public MemberDto memberInfoDao(String mid);
	public int idCheckDao(String mid) ; //회원 아이디로 회원 회원 존재 여부 체크
	public int loginDao(String mid, String mpw);
	public int ModifyDao(String mid, String mpw, String mname, String memail);
}
