package com.test.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.test.Model.Users;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@Test
	public void run() {
		List<Users> selectUser = selectUser(1, "");
		System.out.println(selectUser);
		Boolean checkAccount = checkAccount(1);
		System.out.println(checkAccount);

	}

	public List<Users> selectUser(int id, String pass) {

		List<Users> users = new ArrayList<Users>();

		String sql = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ? ";
		try {
			conn = conn();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			pStmt.setString(2, pass);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Users user = new Users();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				users.add(user);
			}
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Select 失敗");
		}
		return users;
	}

	public Boolean checkAccount(int acc) {
		conn = conn();
		Boolean result = false;
		String sql = "SELECT * FROM USERS WHERE ID = ? ";
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, acc);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				result = true;
			}
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Select 失敗");
		}
		return result;
	}

	public Boolean insertUser(Users user) {
		conn = conn();
		String sql = "INSERT INTO USERS (ID,USERNAME,PASSWORD,EMAIL)VALUES(?,?,?,?)";
		Boolean result = true;
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user.getId());
			pStmt.setString(2, user.getUsername());
			pStmt.setString(3, user.getPassword());
			pStmt.setString(4, user.getEmail());
			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
			System.out.println("Insert 失敗");
		}
		return result;
	}

	public String selectEmailByAcc(int acc) {
		conn = conn();
		String result = "";
		String sql = "SELECT EMAIL FROM USERS WHERE ID = ? ";
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, acc);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				result = rs.getString(1);
			}
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Select 失敗");
		}
		return result;
	}

	public void updatePass(String pass , int acc) {
		conn = conn();
		String sql = "UPDATE USERS SET PASSWORD = ? WHERE ID = ?";
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, pass);
			pStmt.setInt(2, acc);
			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update 失敗");
		}
	}

}
