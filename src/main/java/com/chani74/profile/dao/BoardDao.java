package com.chani74.profile.dao;

import java.util.ArrayList;

import com.chani74.profile.dto.BoardDto;

public interface BoardDao {
	public void writeDao(String bid, String bname, String btitle, String bcontent );
	public ArrayList<BoardDto> listDao () ;
	public BoardDto viewContentDao(int bnum);
	public void modifyContentDao(int bnum, String btitle, String bcontent);
}
