package kr.co.mycom.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.co.mycom.model.BoardDAO;
import kr.co.mycom.model.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		BoardService dao = sqlSession.getMapper(BoardService.class);
		dao.insertBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(HashMap map) {
		BoardService service = sqlSession.getMapper(BoardService.class);
		return service.getBoardList(map);
	}

	@Override
	public BoardDTO getBoard(int num) {
		BoardService service = sqlSession.getMapper(BoardService.class);
		return service.getBoard(num);
	}

	@Override
	public int getBoardCount() {
		BoardService service = sqlSession.getMapper(BoardService.class);
		return service.getBoardCount();
	}

	@Override
	public int updateHit(int num) {
		BoardService service = sqlSession.getMapper(BoardService.class);
		return service.updateHit(num);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		BoardService service = sqlSession.getMapper(BoardService.class);
		return service.updateBoard(dto);
	}

	@Override
	public int deleteBoard(BoardDTO dto) {
		BoardService service = sqlSession.getMapper(BoardService.class);
		return service.deleteBoard(dto);
	}

	@Override
	public void insertReply(BoardDTO dto) {
		BoardService service = sqlSession.getMapper(BoardService.class);
		service.updateSort(dto);
		service.insertReply(dto);
	}

	@Override
	public void updateSort(BoardDTO dto) {
		BoardService service = sqlSession.getMapper(BoardService.class);
		service.updateSort(dto);
	}

}
