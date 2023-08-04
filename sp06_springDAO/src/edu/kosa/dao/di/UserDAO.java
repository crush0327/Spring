package edu.kosa.dao.di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import edu.kosa.model.UsersVO;

public class UserDAO {

	@Autowired
	private ConnectionMaker connectionMaker; // has-a

//	public UserDAO(ConnectionMaker connectionMaker) {	//DI - constructor
//		super();
//		this.connectionMaker = connectionMaker;
//	}

	public UserDAO() {
	}

	//
//	public void setConnectionMaker(ConnectionMaker connectionMaker) {	//DI - setter method
//		this.connectionMaker = connectionMaker;
//	}

	public UserDAO(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	// 3.DML 명령어
	// insert
	public void insert(UsersVO vo) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		String sql = "Insert into Users values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getPassword());
		int result = pstmt.executeUpdate();
		System.out.println(result + " 개 입력 성공!!!");

		pstmt.close();
		conn.close();
	}

	public void selectAll() throws Exception {
		Connection conn = connectionMaker.makeConnection();
		String sql = "select * from USERS";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<UsersVO> list = new ArrayList();
		while (rs.next()) {
			UsersVO vo = new UsersVO();
			vo.setId(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setPassword(rs.getString(3));
			list.add(vo);
		}
		System.out.println("아이디\t" + "\t이름\t" + "\t암호");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t" + list.get(i).getPassword());
		}
		rs.close();
		pstmt.close();
		conn.close();
	}

	// selectById
	public void selectById(String Id) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		String sql = "select * from USERS where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Id);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<UsersVO> list = new ArrayList();
		while (rs.next()) {
			UsersVO vo = new UsersVO();
			vo.setId(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setPassword(rs.getString(3));
			list.add(vo);
		}
		System.out.println("아이디\t" + "\t이름\t" + "\t암호");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t" + list.get(i).getPassword());
		}
		rs.close();
		pstmt.close();
		conn.close();
	}

	// update
	public void update(String Id) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		String sql = "select * from USERS where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Id);
		ResultSet rs = pstmt.executeQuery();
		if (!rs.next()) {
			System.out.println("id가 존재하지 않습니다.");
			return;
		}

		sql = "update USERS set name=?, password=? where id=?";
		pstmt = conn.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("변경하고자 하는 이름을 입력해주세요.");
		String name = sc.next();
		System.out.println("변경하고자 하는 암호를 입력해주세요.");
		String password = sc.next();
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		pstmt.setString(3, Id);
		int num = pstmt.executeUpdate();
		if (num >= 1)
			System.out.println("업데이트에 성공하였습니다.");
		pstmt.close();
		conn.close();
	}

	// delete
	public void delete(String Id) throws Exception {
		Connection conn = connectionMaker.makeConnection();
		String sql = "delete from USERS where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Id);
		int num = pstmt.executeUpdate();
		if (num >= 1)
			System.out.println("삭제에 성공하였습니다.");
		pstmt.close();
		conn.close();
	}

	// menu
	public void menu() {
		System.out.println("==========================================================");
		System.out.println("선택하세요: \n1.insert");
		System.out.println("2.SelectAll \n3.SelectById \n4.Update \n5.Delete \n6.종료");
		System.out.println("==========================================================");
	}
}
