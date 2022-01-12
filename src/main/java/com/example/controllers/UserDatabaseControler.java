package com.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.models.User;

public class UserDatabaseControler {

	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insert(User user) {
		String query = "insert into user(id,name,email,gender,password) values(?,?,?,?,?)";

		int update = template.update(query, user.getId(), user.getName(), user.getEmail(), user.getGender(),
				user.getPassword());
		return update;
	}

	public int update(User user) {
		String query = "update user set name=?,email=?,gender=?,password=? where id=?";

		int update = template.update(query, user.getName(), user.getEmail(), user.getGender(), user.getPassword(),
				user.getId());
		return update;
	}

	public int delete(int id) {
		String query = "delete from user where id=?";

		int update = template.update(query, id);
		return update;
	}

	public List<User> getAll() {
		String query = "select * from user";

		List<User> list = template.query(query, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setGender(rs.getString(4));
				user.setPassword(rs.getString(5));
				return user;
			}

		});
		return list;

	}

	public User getUserData(String email, String password) {
		String query = "select * from user where email='" + email + "' AND password='" + password + "'";

		List<User> list = template.query(query, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setGender(rs.getString(4));
				user.setPassword(rs.getString(5));
				return user;
			}

		});
		return list.size() > 0 ? list.get(0) : null;

	}

}
