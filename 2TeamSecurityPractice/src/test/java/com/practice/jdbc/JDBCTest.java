package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.Oracleriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		try(Connection con=
			DriverManager.getConnection(
					"",
					"",
					"")){				
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}

