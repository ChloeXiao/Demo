package com.test.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	public Connection conn;

	public Connection conn() {
		String driver = "oracle.jdbc.driver.OracleDriver"; // �O�o�U���ݭn�ϥΨ쪺dirver jar��
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("�X�ʵ{���S�W�u");
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			conn = DriverManager.getConnection(url, "HR", "HR");
			System.out.println("��Ʈw�s�u���\!!");
		} catch (SQLException e) {
			System.err.println("��Ʈw�s�u����");
			e.printStackTrace();
		}
		return conn;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("��Ʈw�s�u������!!");
			e.printStackTrace();
		}
	}

}
