package com.kosa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.kosa.config.SqlSessionFactoryService;
import com.kosa.model.BoardVO;

@Component
public class BoardDAO {

	private SqlSessionFactoryService sqlSessionFactory;
	private SqlSession sqlSession = null;

	public List<BoardVO> selectAll() {
		try {
//			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession(true);
			sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
			return sqlSession.selectList("dao.selectAll");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public BoardVO selectBySeq(int seq) {
		try {
			System.out.println(seq);
//			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession(true);
			sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
			BoardVO vo = sqlSession.selectOne("dao.selectBySeq", seq);
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public int insert(BoardVO vo) {
		int num = 0;
		try {
//			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession(true);
			sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
			num = sqlSession.insert("dao.insert", vo);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public int delete(int seq) {
		int num = 0;
		try {
//			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession(true);
			sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
			num = sqlSession.delete("dao.delete", seq);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public int update(BoardVO vo) {
		int num = 0;
		try {
//			sqlSession = sqlSessionFactory.getSqlSessionInstance().openSession(true);
			sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
			num = sqlSession.update("dao.update", vo);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 전체 검색 조회 - 1
	public List<BoardVO> selectSearchList(Map<String, String> map) {
		try {
			/*
			 * for(Map.Entry<Stirng,String>) m : map.entrySet()){
			 * System.out.print(m.getKey()+"/"+m.getValue()+"-");
			 */
			sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
			return sqlSession.selectList("dao.selectSearch", map);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	// 전체 검색 조회 - 2
	public List<BoardVO> selectSearchList2(Map<String, String> map) {
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
			return sqlSession.selectList("dao.selectSearch2", map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	public int updateReadCount(Map<String, Integer> map) {
		sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
		int num = 0;
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionInstance().openSession(true);
			num = sqlSession.update("dao.updateReadCount",map);
			return num;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
