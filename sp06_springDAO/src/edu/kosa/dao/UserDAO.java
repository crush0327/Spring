package edu.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.kosa.model.UsersVO;

public abstract class UserDAO {	//추상클래스

	//DB연결
	public abstract Connection getConnction() throws Exception; //추상 메소드
	
	//3. 사용(DML 명령어)
	
	//insert
	public void insert(UsersVO vo) throws Exception{
			Connection conn = getConnction();
			String sql = "Insert into Users values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			int result = pstmt.executeUpdate();
			System.out.println(result+ " 개 입력 성공!!!");
			
			pstmt.close();
			conn.close();
	}

	//selectAll
	public void selectAll() throws Exception {
		Connection conn = getConnction();
		String sql = "select * from USERS";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt=conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<UsersVO> list = new ArrayList();
		while(rs.next()) {
			UsersVO vo = new UsersVO();
			vo.setId(rs.getString(1));			
			vo.setName(rs.getString(2));			
			vo.setPassword(rs.getString(3));
			list.add(vo);
		}
		System.out.println("아이디\t"+"\t이름\t"+"\t암호");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+list.get(i).getPassword());
		}
		rs.close();
		pstmt.close();
		conn.close();
	}
	
	//selectById
	public void selectById(String Id) throws Exception {
		Connection conn = getConnction();
		String sql = "select * from USERS where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, Id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<UsersVO> list = new ArrayList();
		while(rs.next()) {
			UsersVO vo = new UsersVO();
			vo.setId(rs.getString(1));			
			vo.setName(rs.getString(2));			
			vo.setPassword(rs.getString(3));
			list.add(vo);
		}
		System.out.println("아이디\t"+"\t이름\t"+"\t암호");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+list.get(i).getPassword());
		}
		rs.close();
		pstmt.close();
		conn.close();
	}
	
	//update
	
	
	
	//delete
	public void delete(String Id) throws Exception {
	Connection conn = getConnction();
	String sql = "delete from USERS where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, Id);
	int num = pstmt.executeUpdate();
	if(num>=1) System.out.println("삭제에 성공하였습니다.");
	pstmt.close();
	conn.close();
	}
	
	//menu
	public void menu() {
		System.out.println("선택하세요: \n1.insert");
		System.out.println("2.SelectAll \n3.SelectById \n4.Update \n5.Delete");
	}


}
