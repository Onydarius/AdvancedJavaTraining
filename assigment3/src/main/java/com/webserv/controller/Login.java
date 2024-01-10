package com.webserv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webserv.dao.UserDao;
import com.webserv.model.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
	UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);

		int result = userDao.checkuser(user);

		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("all");
		} else {
			response.sendRedirect("login.jsp");
		}

	}


}
