package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;

// Oracle DB Connection 
public class ConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.22:1521:orcl";
		String uid = "kingsmile";
		String pwd = "oracle";

		Connection conn = DriverManager.getConnection(url, uid, pwd);

		return conn;
	}

}
