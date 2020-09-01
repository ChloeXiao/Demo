package tw.com.phctw.demo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentService;
import tw.com.phctw.service.StudentServiceImpl;

public class JdbcDemo {
	private static Boolean exist;

	public static void main(String[] args) throws SQLException {
		Boolean boo = true;
		StudentService sever = new StudentServiceImpl();
		List<Student> list = new ArrayList<Student>();

		while (boo) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1.查詢  2.新增 3.修改 4.刪除");
			System.out.println("--------------------------");
			int choose = scanner.nextInt();
			if (choose == 1) {
				// 查詢
				list = sever.selectStudent();
				System.out.println("SNO " + "SNAME " + "SBDAY " + "SSEX " + "SMAIL " + "SPWD ");
				list.forEach(data -> {
					System.out.println(data.getSno() + " " + data.getSname() + " " + data.getSbday() + " "
							+ data.getSsex() + " " + data.getSmail() + " " + data.getSpwd());
				});
			} else if (choose == 2) {
				// 新增
				exist = true;
				Student student = new Student();
				student.setSno("A06");
				student.setSname("測試");
				student.setSbday(new Date());
				student.setSsex(0);
				student.setSmail("PHCTWSTUDENT001@GMAIL.COM");
				student.setSpwd("123456");
				list.forEach(data -> {
					if (data.getSno().equals(student.getSno())) {
						exist = false;
						System.out.println("無法新增，已有相同資料!");
					}
				});
				if (exist) {
					Boolean result = sever.insertStudent(student);
					System.out.println("新增" + " " + result);
				}
			} else if (choose == 3) {
				// 修改
				Student student = new Student();
				student.setSname("更新測試");
				student.setSno("A06");
				int count = sever.updateStudent(student);
				System.out.println("更新 " + count + " 筆資料");
			} else if (choose == 4) {
				// 刪除
				String sno = "A06";
				Boolean result = sever.deleteStudent(sno);
				System.out.println("刪除 " + " " + result);
			} else {
				System.out.println("重新選擇");
			}
		}
	}

}
