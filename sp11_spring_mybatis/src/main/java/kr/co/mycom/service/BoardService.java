package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import kr.co.mycom.model.BoardDTO;

public interface BoardService {
	public void insertBoard(BoardDTO dto);
	public List<BoardDTO> getBoardList(HashMap map);
	public BoardDTO getBoard(int num);
	public int getBoardCount();
	public int updateHit(int num);
	public int updateBoard(BoardDTO dto);
	public int deleteBoard(BoardDTO dto);
	public void insertReply(BoardDTO dto);
	public void updateSort(BoardDTO dto);
}
