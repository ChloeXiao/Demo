package tw.com.phctw.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.StudentDao;

public class StudentServiceImpl extends StudentDao implements StudentService {
	public PreparedStatement pStmt;

	@Override
	public List<Student> selectStudent() {
		List<Student> student = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";
		try {
			conn = conn();
			pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery(sql);
			while (rs.next()) {
				Student s = new Student();
				s.setSno(rs.getString(1));
				s.setSname(rs.getString(2));
				s.setSbday(rs.getDate(3));
				s.setSsex(rs.getInt(4));
				s.setSmail(rs.getString(5));
				s.setSpwd(rs.getString(6));
				student.add(s);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Select 失敗");
		}
		return student;
	}

	@Override
	public Boolean insertStudent(Student student) {
		Boolean result = true;
		Date sqlDate = new Date(student.getSbday().getTime());
		String sql = "INSERT INTO STUDENT(SNO,SNAME,SBDAY,SSEX,SMAIL,SPWD) VALUES(? , ? , ? , ? , ? , ?)";
		try {
			conn = conn();
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, student.getSno());
			pStmt.setString(2, student.getSname());
			pStmt.setDate(3, sqlDate);
			pStmt.setInt(4, student.getSsex());
			pStmt.setString(5, student.getSmail());
			pStmt.setString(6, student.getSpwd());
			pStmt.executeUpdate();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
			System.out.println("Insert 失敗");
		}
		return result;
	}

	@Override
	public Integer updateStudent(Student student) {
		int count = 0;
		String sql = "UPDATE STUDENT SET SNAME = ?  WHERE SNO = ?";
		try {
			conn = conn();
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, student.getSname());
			pStmt.setString(2, student.getSno());
			count = pStmt.executeUpdate();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update 失敗");
		}

		return count;
	}

	@Override
	public Boolean deleteStudent(String sno) {
		String sql = "DELETE FROM STUDENT WHERE SNO = ?";
		Boolean result = true;
		try {
			conn = conn();
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, sno);
			pStmt.executeUpdate();
			close();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
			System.out.println("DELETE 失敗");
		}
		return result;
	}

}
