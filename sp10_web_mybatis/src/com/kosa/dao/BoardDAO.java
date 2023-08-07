package com.kosa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.kosa.config.SqlSessionFactoryService;
import com.kosa.model.BoardVO;

@Component
public class BoardDAO {

	private SqlSessionFactoryService sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리 함수를 갖고 있다.

	// select all
	public List<BoardVO> selectAll() {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionFactory().openSession(); // app과 db 연결 통로
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

	// insert
	public int insert(BoardVO vo) {
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession();
			int result = sqlSession.insert("dao.insert", vo);
			sqlSession.commit(); //
			return result;
		} catch (Exception e) {
//			sqlSession.rollback();  // 단일 쿼리 실행시 의미가 없다.
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // write end

	// detail list
	public BoardVO detailList(int seq) {
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession();
			BoardVO vo = sqlSession.selectOne("dao.detailList", seq);
			return vo;
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	} // end detailList

	// update
	public int update(BoardVO vo) {
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession(true);
			int rowcount = sqlSession.update("dao.update", vo);
			// sqlSession.commit();
			return rowcount;

		} catch (Exception e) {
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	} // end update

	// 전체 검색 조회 - 1
	public List<BoardVO> selectSearchList(Map<String, String> map) {
		try {
			/*
			 * for(Map.Entry<String, String>) m : map.entrySet() ) {
			 * System.out.println(m.getKey() + "/ " + m.getValue() + "-"); }
			 */
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession();
			return sqlSession.selectList("dao.selectSearch", map);

		} catch (Exception e) {
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
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession();
			return sqlSession.selectList("dao.selectSearch2", map);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// delete
	public int delete(int seq) {
		try {
			sqlSession = SqlSessionFactoryService.getSqlSessionFactory().openSession();
			int rowcount = sqlSession.delete("dao.delete", seq);
			sqlSession.commit();
			return rowcount;

		} catch (Exception e) {
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // delete end
}
