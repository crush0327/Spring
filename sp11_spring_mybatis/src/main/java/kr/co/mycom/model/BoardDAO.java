package kr.co.mycom.model;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	public void insertBoard(BoardDTO dto);
	public List<BoardDTO> getBoardList(HashMap map);
	public BoardDTO getBoard(int num);
	
}
