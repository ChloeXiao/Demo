package tw.com.phctw.Dao;

import java.sql.SQLException;
import java.util.List;

import tw.com.phctw.Model.Student;

public interface StudentDao {

	public List<Student> selectStudent() throws SQLException; // �d�߾ǥ͸��

	public int insertStudent(List<Student> student) throws SQLException; // �s�W�ǥ͸��

}
