package tw.com.phctw.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.phctw.Model.Student;

public class StudentDaoImpl extends Dao implements StudentDao {

	private PreparedStatement pStmt;

	public StudentDaoImpl() {
		conn();
	}

	public List<Student> selectStudent() {
		List<Student> student = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT ORDER BY SNO";
		try {
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
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Select ¥¢±Ñ");
		}
		return student;
	}

	public int insertStudent(List<Student> student) {
		int count = 0;
		String sql = "INSERT INTO STUDENT(SNO,SNAME,SBDAY,SSEX,SMAIL,SPWD) VALUES(? , ? , ? , ? , ? , ?)";
		try {
			pStmt = conn.prepareStatement(sql);
			for (Student s : student) {
				Date sqlDate = new Date(s.getSbday().getTime());
				pStmt.setString(1, s.getSno());
				pStmt.setString(2, s.getSname());
				pStmt.setDate(3, sqlDate);
				pStmt.setInt(4, s.getSsex());
				pStmt.setString(5, s.getSmail());
				pStmt.setString(6, s.getSpwd());
				pStmt.executeUpdate();
				count++;
			}
			pStmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert ¥¢±Ñ");
		}
		return count;
	}

}
