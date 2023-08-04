package edu.kosa.dao.di;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/DB명";
		String uid = "kingsmile";
		String pwd = "oㅡㅛㄴ비";
		
		Connection conn = DriverManager.getConnection(url,uid,pwd);
		return conn;
	}

}
