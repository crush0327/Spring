package board.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.BoardVO;
import config.SqlSessionFactoryBean;

public class BoardDAO {
	
	private  SqlSession   sqlSession;
	
	public BoardDAO() {
		sqlSession = SqlSessionFactoryBean.getSqlSessionInstance();   // 
	}
	
	public List<BoardVO>  selectAll() {
		return  sqlSession.selectList("dao.selectAll");
	}
	
	public void update(BoardVO vo) {
		sqlSession.update("dao.update", vo);
		sqlSession.commit();  // mybatis 자동 커밋 안됨
	}
	
	public void insert(BoardVO vo) {
		sqlSession.insert("dao.insert", vo);
		sqlSession.commit();
	}
	
//	public  void close() {
//		sqlSession.close();
//	}
}







