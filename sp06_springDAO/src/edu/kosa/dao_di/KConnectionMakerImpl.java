package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.DriverManager;

public class KConnectionMakerImpl implements ConnectionMaker {

	@Override
	public Connection makeConnection() throws Exception {
		Class.forName("infomics");
		String user = "kingsmile";
		String pwd = "info";
		String url = "infomics";
		
		Connection conn = DriverManager.getConnection(url, user, pwd);

		return conn;
	}

}
