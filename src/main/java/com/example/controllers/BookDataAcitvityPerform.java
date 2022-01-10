package com.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.models.Book;

public class BookDataAcitvityPerform {
	JdbcTemplate template;

	public int insert(Book book) {
		String query = "insert into book(id,name,description) values(?,?,?)";
		int update = template.update(query, book.getId(), book.getName(), book.getDescription());
		return update;
	}

	public int delete(int id) {
		String query = "delete from book where id=?";
		int update = template.update(query, id);
		return update;
	}

	public List<Book> getAll() {
		String query = "select * from book";
		List<Book> list = template.query(query, new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setDescription(rs.getString(3));
				book.setQty(rs.getString(4));
				return book;
			}
		});
		return list;

	}

	public Book getbookData(Integer id) {
		String query = "select * from book where id='" + id + "'";

		List<Book> list = template.query(query, new RowMapper<Book>() {

			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setDescription(rs.getString(3));

				return book;
			}

		});
		return list.size() > 0 ? list.get(0) : new Book();

	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
