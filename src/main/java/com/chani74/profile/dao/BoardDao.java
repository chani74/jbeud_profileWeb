package com.chani74.profile.dao;

import java.util.ArrayList;

import com.chani74.profile.dto.BoardDto;

public interface BoardDao {
	public void writeDao(String bid, String bname, String btitle, String bcontent );
	public ArrayList<BoardDto> listDao (int amount , int pageNum) ;
	public BoardDto viewContentDao(int bnum);
	public void modifyContentDao(int bnum, String btitle, String bcontent);
	public int deleteContentDao(int bnum);
	public void hitContentDao(int bnum);
	
	public int totalBoardCountDao();
}
