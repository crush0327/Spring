package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.mycom.model.BoardDAO;
import kr.co.mycom.model.BoardDTO;

@Component     // bean create
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSession sqlSession;   // has-a

	@Override
	public void insertBoard(BoardDTO dto) {
		BoardService  dao = sqlSession.getMapper(BoardService.class);
		dao.insertBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(HashMap map) {
		BoardService dao = sqlSession.getMapper(BoardService.class);
		return dao.getBoardList(map);
	}
	
	@Override
	public int getBoardCount() {
		BoardService  dao = sqlSession.getMapper(BoardService.class);
		return dao.getBoardCount();
	}

	@Override
	public BoardDTO getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}



}
