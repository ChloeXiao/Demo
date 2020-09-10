package tw.com.phctw.Dao;

import java.sql.SQLException;
import java.util.List;

import tw.com.phctw.Model.Student;

public interface StudentDao {

	public List<Student> selectStudent() throws SQLException; // 查詢學生資料

	public int insertStudent(List<Student> student) throws SQLException; // 新增學生資料

}
