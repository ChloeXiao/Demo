package com.test.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.Dao.UserService;
import com.test.Model.Users;

@Namespace("/")
@ResultPath(value = "/WEB-INF/views")
public class HelloWorldAction extends ActionSupport {

	@Autowired
	private UserService userService;
	public static final long serialVersionUID = 1;
	private LoginBean loginBean;
	private SingIn singIn;
	private NewPass newPass;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public SingIn getSingin() {
		return singIn;
	}

	public void setSingIn(SingIn singIn) {
		this.singIn = singIn;
	}

	public NewPass getNewPass() {
		return newPass;
	}

	public void setNewPass(NewPass newPass) {
		this.newPass = newPass;
	}

	@Action(value = "login", results = { @Result(name = "ok", location = "helloworld.jsp") })
	public String logins() {
		// 登入
		ActionContext actionContext = ActionContext.getContext();
		List<Users> user = new ArrayList<Users>();
		if (loginBean.getAcc() != null && loginBean.getPassword() != null) {
			int accId = Integer.valueOf(loginBean.getAcc());
			String pass = userService.getMD5Str(loginBean.getPassword());
			user = userService.selectUserService(accId, pass);
		}
		// 把值放到畫面
		if (user != null) {
			Map<String, Object> session = actionContext.getSession();
			session.put("id", user.get(0).getId());
			session.put("username", user.get(0).getUsername());
			session.put("email", user.get(0).getEmail());
		}
		return "ok";
	}

	// 註冊
	@Action(value = "singin", results = { @Result(name = "ok", location = "singins.jsp") })
	public String singin() {
		if (singIn != null) {
//			// 密碼加密
			String passMD5 = userService.getMD5Str(singIn.getPassword());
//			// 新增users資料
			int accs = Integer.valueOf(singIn.getAcc());
			userService.insertUserService(accs, singIn.getUserName(), passMD5, singIn.getEmail());
		}
		return "ok";
	}

	// 忘記密碼
	@Action(value = "newPass", results = { @Result(name = "ok", location = "newpass.jsp") })
	public String newPass() {
		System.out.println("in newPass");
		int accs = Integer.valueOf(newPass.getAcc());
		userService.sendEmail(accs);
		return "ok";
	}
	
	@Action(value = "checkId")
	public String checkId() {
		Boolean result = null;
		String s = "";
		int acc = Integer.valueOf(singIn.getAcc());
		result = userService.checkId(acc);
		if (result) {
			s = "true";
		} else {
			s = "false";
		}
		return s;
	}

	public String checkEmail() {
		Boolean result = userService.checkEmail(singIn.getEmail());
		String s = "";
		if (result) {
			s = "true";
		} else {
			s = "false";
		}
		return s;

	}

}
