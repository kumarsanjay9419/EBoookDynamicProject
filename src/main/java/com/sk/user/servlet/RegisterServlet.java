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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String phno=req.getParameter("phno");
			String password=req.getParameter("password");
			String check=req.getParameter("check");
			//System.out.println(name+" "+email+" "+phno+" "+password+" "+check);
			
			User user =new User();
			user.setName(name);
			user.setEmail(email);
			user.setPhno(phno);
			user.setPassword(password);
			user.setCheck(check);
			
			HttpSession session = req.getSession();
			
			if(check!=null) {
				UserDAOImpl dao=new UserDAOImpl(DBConnect.getCon()); 
				boolean f = dao.userRegistration(user);
				if(f) {
					//System.out.println("User Registration Success.....");
					session.setAttribute("successMsg","User Registration Successfully....");
					resp.sendRedirect("register.jsp");
				}else {
					//System.out.println("Something went wrong.......");
					session.setAttribute("failedMsg","Something went wrong.......");
					resp.sendRedirect("register.jsp");
				}
			}else {
				//System.out.println("Please check Terms & Condition.....");
				session.setAttribute("failedMsg","Please check Terms & Condition.....");
				resp.sendRedirect("register.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
