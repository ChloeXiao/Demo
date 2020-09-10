package com.test.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.Dao.UserService;
import com.test.Model.Users;

@Controller
public class HelloWorldController {

	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	public ModelAndView login(@RequestParam(value = "acc", required = false) String acc,
			@RequestParam(value = "password", required = false) String pass,
			@RequestParam(value = "submit", required = false) String submit) {
		// 登入
		List<Users> user = new ArrayList<Users>();
		if (submit != null && acc != null && pass != null) {
			// 密碼加密
			int accId = Integer.valueOf(acc);
			String passs = userService.getMD5Str(pass);
			user = userService.selectUserService(accId, passs);
		}
		ModelAndView mvs = new ModelAndView("helloworld");
		mvs.addObject("user", user);
		return mvs;
		// 導頁 & 傳值給 helloworld.jsp
//		mv.addObject("message", message);
//		mv.addObject("name", account);
//		return mv;
	}

//	// 註冊
	@RequestMapping("/singin")
	public ModelAndView singin(@RequestParam(value = "acc", required = false) String acc,
			@RequestParam(value = "pass", required = false) String pass,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "check", required = false) String check,
			@RequestParam(value = "btn", required = false) String btn) {
		String s = "";
		if (check != null) {
			int accs = Integer.valueOf(acc);
			// 檢核帳號
			checkId(accs);
		}
		if (btn != null) {
			// 密碼加密
			String passMD5 = userService.getMD5Str(pass);
			// 新增users資料
			int accs = Integer.valueOf(acc);
			Boolean result = userService.insertUserService(accs, userName, passMD5, email);
			if (result) {
				s = "true";
			} else {
				s = "false";
			}
		}
		ModelAndView mvs = new ModelAndView("singins");
		mvs.addObject(s);
		return mvs;
	}

	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	@ResponseBody
	public String checkId(@RequestParam(value = "acc", required = false) int acc) {
		Boolean result = null;
		String s = "";
		result = userService.checkId(acc);
		if (result) {
			s = "true";
		} else {
			s = "false";
		}
		return s;
	}

	@RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
	@ResponseBody
	public String checkEmail(@RequestParam(value = "email", required = false) String email) {
		Boolean result = userService.checkEmail(email);
		String s = "";
		if (result) {
			s = "true";
		} else {
			s = "false";
		}
		return s;

	}

	@RequestMapping(value = "/newPass", method = RequestMethod.POST)
	public ModelAndView newPass(@RequestParam(value = "acc", required = false) String acc,
			@RequestParam(value = "submit", required = false) String submit) {
		System.out.println("in newPass");
		if (submit != null) {
			int accs = Integer.valueOf(acc);
			userService.sendEmail(accs);
		}
		ModelAndView mvs = new ModelAndView("newpass");
		return mvs;
	}

}
