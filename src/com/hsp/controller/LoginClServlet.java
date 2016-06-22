package com.hsp.controller;

import com.hsp.domain.User;
import com.test.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginClServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 接收用户提交的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 这里看看接到没？
		// 这里我们先简单验证
		if ("123".equals(password)) {
			// 跳转到下一个页面[servlet提供了两种：1、sendRedirect转向2、forward转发]
			// sendRedirect的url应该这样写：/web应用名/servlet url
//			MyData.name = username;
			
			// 使用session来传递数据给下个页面。这种方法传参的好处，不仅可以传字符串，而且可以传对象。
			request.getSession().setAttribute("loginuser", username);
			// session可以传递对象
			User user = new User();
			user.setName(username);
			user.setPwd(password);
			request.getSession().setAttribute("userobj", user);
			
			response.sendRedirect("/UsersManager/MainFrame?uname=" + username + "&pwd=" + password);
		} else {
			// 跳回
			response.sendRedirect("/UsersManager/LoginServlet");
		}
		System.out.println(username + " " + password);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			
			this.doGet(request, response);
		}
	
}
