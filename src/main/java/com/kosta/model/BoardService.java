package com.kosta.model;

import java.sql.Date;
import java.util.List;

import com.kosta.dto.BoardDTO;
import com.kosta.dto.BoardEmpVO;


public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	public List<BoardEmpVO> selectAllJoin() {
		return dao.selectAllJoin();
	}
	public List<BoardDTO> selectAll() {;
		return dao.selectAll();
	}
	public BoardDTO selectById(int bno) {
		return dao.selectById(bno);
	}
	public List<BoardDTO> selectByWriter(int writer) {
		return dao.selectByWriter(writer);
	}
	public List<BoardDTO> selectByTitle(String title) {
		return dao.selectByTitle(title);
	}
	public List<BoardDTO> selectByRegDate(Date sdate, Date edate) {
		return dao.selectByRegDate(sdate, edate);
	}
	public int insert(BoardDTO board) {
		return dao.insert(board);
	}
	public int update(BoardDTO board) {
		return dao.update(board);
	}
	public int delete(int bno) {
		return dao.delete(bno);
	}
}
