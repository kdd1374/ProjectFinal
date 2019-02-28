package com.notice;

import java.util.Date;

public class Board {
	
	private int id = 0;
	private String name = null;
	private String title = null;
	private String createDate = null;
	private String email = null;
	private String content = null;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int id, String name, String title, String createDate, String email, String content) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.createDate = createDate;
		this.email = email;
		this.content = content;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	

}

