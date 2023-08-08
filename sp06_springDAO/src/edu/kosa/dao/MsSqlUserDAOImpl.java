package edu.kosa.dao;

import java.sql.Connection;

public class MsSqlUserDAOImpl extends UserDAO {

	@Override
	public Connection getConnection() throws Exception {
		// MSSQL 관련 연결
		return null;
	}

}
