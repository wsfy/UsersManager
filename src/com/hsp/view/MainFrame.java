package com.hsp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsp.domain.User;
import com.test.MyData;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取登录名
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		String username2 = (String) request.getSession().getAttribute("loginuser");
		
		// 获取session中的对象
		
		User user = (User) request.getSession().getAttribute("userobj");
		out.println("<h1>主界面</h1>" + username + " pwd = " + password + "" + username2 + "||" + user.getName() + "" + user.getPwd());
		out.println("<a href='/UsersManager/LoginServlet'>返回重新登录</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
