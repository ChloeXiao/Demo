package com.test.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	public Connection conn;

	public Connection conn() {
		String driver = "oracle.jdbc.driver.OracleDriver"; // 記得下載需要使用到的dirver jar檔
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("驅動程式沒上線");
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			conn = DriverManager.getConnection(url, "HR", "HR");
			System.out.println("資料庫連線成功!!");
		} catch (SQLException e) {
			System.err.println("資料庫連線失敗");
			e.printStackTrace();
		}
		return conn;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("資料庫連線未關閉!!");
			e.printStackTrace();
		}
	}

}
