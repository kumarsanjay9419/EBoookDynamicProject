package com.sk.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sk.DAO.UserDAO;
import com.sk.entities.User;

public class UserDAOImpl implements UserDAO {

	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean userRegistration(User user) {
		boolean f = false;
		try {
			String sql = "INSERT INTO user(name,email,phno,password) values(?,?,?,?)";
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPhno());
			prepareStatement.setString(4, user.getPassword());
			int executeUpdate = prepareStatement.executeUpdate();
			if (executeUpdate == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}

	@Override
	public User userLogin(String email, String password) {

		User user = null;
		try {
			String sql = "SELECT * from user where  email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhno(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setLandmark(rs.getString(6));
				user.setCity(rs.getString(7));
				user.setState(rs.getString(8));
				user.setPincode(rs.getString(9));
				user.setAddress(rs.getString(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
