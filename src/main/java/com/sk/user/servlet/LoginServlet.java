package com.sk.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sk.DAO.Impl.UserDAOImpl;
import com.sk.DB.DBConnect;
import com.sk.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserDAOImpl dao=new UserDAOImpl(DBConnect.getCon()); 
			HttpSession session = req.getSession();
			String adminEmail="admin@gmail.com";
			String admin="admin";
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			System.out.println(email+" "+password );
			
			if(adminEmail.equalsIgnoreCase(email)&& "admin".equalsIgnoreCase(password)) {
				User us=new User();
				session.setAttribute("userObj", us);
				resp.sendRedirect("admin/home.jsp");
			}else {
				User us = dao.userLogin(email,password);
				if(us!=null) {
					session.setAttribute("userObj", us);
					resp.sendRedirect("home.jsp");
				}else {
					session.setAttribute("faildMsg", "Email & Password Invalid !!");
					resp.sendRedirect("login.jsp");
				}
				//resp.sendRedirect("home.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
