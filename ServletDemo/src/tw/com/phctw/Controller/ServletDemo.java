package tw.com.phctw.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.phctw.Dao.StudentDao;
import tw.com.phctw.Dao.StudentDaoImpl;
import tw.com.phctw.Dao.StudentService;
import tw.com.phctw.Model.Student;

@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDemo() {
		super();
	}

	public static void main(String[] args) {
//		 大樂透 01-49 選6個號碼
		Random random = new Random();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			String number = String.valueOf(random.nextInt(38) + 1);
			list.add(number);
		}
		String numbers =String.valueOf(random.nextInt(8) + 1);
		list.add(numbers);
		list.forEach(data ->{
			System.out.println(data);
		});
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int success = 0;
		int fail = 0;
		List<Student> list = new ArrayList<Student>();
		String name = request.getParameter("submit");
		String insert = request.getParameter("insert");
		String count = request.getParameter("count");
		String select = request.getParameter("select");
		if (name == null && insert == null && select == null) {
			response.sendRedirect("index.jsp");
		} else if (name != null && insert == null && select == null) {
			response.sendRedirect("inserStudent.jsp");
		}
		if (insert != null && count.isEmpty() && select == null) {
			request.getSession().setAttribute("error", "Error!請輸入筆數");
			request.getRequestDispatcher("inserStudent.jsp").forward(request, response); // getRequestDispatcher請求轉發，前後頁面共享一個request
			return;
		} else if (insert != null && count != null && select == null) {
			String countString = request.getParameter("count");
			int counts = Integer.valueOf(countString);
			StudentService service = new StudentService();
			try {
				success = service.insertStudent(counts);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			fail = counts - success;
			request.getSession().setAttribute("successCount", success);
			request.getSession().setAttribute("failCount", fail);
			request.getRequestDispatcher("inserStudent.jsp").forward(request, response); // getRequestDispatcher請求轉發，前後頁面共享一個request
			return;
		}
		if (select != null) {
			StudentDao dao = new StudentDaoImpl();
			try {
				list = dao.selectStudent();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("studentList", list);
			request.getRequestDispatcher("showStudent.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
