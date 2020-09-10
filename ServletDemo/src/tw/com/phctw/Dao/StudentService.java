package tw.com.phctw.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tw.com.phctw.Model.Student;

public class StudentService {
	StudentDao dao = new StudentDaoImpl();

	public List<Student> selectStudent() throws SQLException {
		List<Student> s = new ArrayList<Student>();
		s = dao.selectStudent();
		return s;
	}

	public int insertStudent(int count) throws SQLException {
		int success = 0;
		List<Student> list = new ArrayList<Student>();
		for (int i = 0; i < count; i++) {
			Student s = new Student();
			s.setSno("D0" + i);
			s.setSname("ด๚ธี" + " " + i);
			s.setSbday(new Date());
			s.setSsex(0);
			s.setSmail("PHCTWSTUDENT001@GMAIL.COM");
			s.setSpwd("123456");
			list.add(s);
		}
		success = dao.insertStudent(list);
		return success;
	}

}
