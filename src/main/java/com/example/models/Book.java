package com.example.models;

public class Book {
	private int id;
	private String name;
	private String description;
	private String qty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public Book(String id, String name, String description) {
		super();
		this.id = Integer.parseInt(id);
		this.name = name;
		this.description = description;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
