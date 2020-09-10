package com.test.Dao;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Model.Users;

@Service("UserService")
public class UserService {

	@Autowired(required = true)
	private UserDao userDao;


	public List<Users> selectUserService(int id, String pass) {
		List<Users> user = new ArrayList<Users>();
		user = userDao.selectUser(id, pass);
		return user;
	}

	public Boolean insertUserService(int acc, String userName, String pass, String email) {
		Boolean result = null;
		Users user = new Users();
		user.setId(acc);
		user.setUsername(userName);
		user.setPassword(pass);
		user.setEmail(email);
		result = userDao.insertUser(user);
		return result;
	}

	public Boolean checkId(int id) {
		Boolean result = null;
		result = userDao.checkAccount(id);
		return result;
	}

	public String getMD5Str(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			System.out.println("result: " + buf.toString());// 32位的加密
			System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	public void sendEmail(int acc) {
		String userEmail = userDao.selectEmailByAcc(acc);
		String pass = "123";
		String host = "smtp.gmail.com";
		int port = 587;

		final String username = "littleguaiguaichiou@gmail.com";
		final String password = "littleguai";// your password

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			message.setSubject("測試寄信...");
			message.setText("Hi, 你的新密碼 :" + pass);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);
			Transport.send(message);
			System.out.println("寄送email結束...");
			String newPass = newPass(pass);
			userDao.updatePass(newPass, acc);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public String newPass(String pass) {
		String newPass = getMD5Str(pass);
		return newPass;
	}
	
	public Boolean checkEmail(String email) {
		String format = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
		if (email.matches(format)) {
			return true;
		}else{
			return false;
		}
	}

}
