package tw.com.phctw.service;

import java.util.List;

import tw.com.phctw.bean.Student;

public interface StudentService {

	public List<Student> selectStudent() ; // �d�߾ǥ͸��

	public Boolean insertStudent(Student student); // �s�W�ǥ͸��

	public Integer updateStudent(Student student) ; // �ק�ǥ͸��

	public Boolean deleteStudent(String sno); // �ק�ǥ͸��

}
