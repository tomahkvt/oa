package com.company.model;

import java.util.Date;

public class Book {
	
	private Integer id;
	private String isbn;
	private String author;
	private String title;
	private int Year;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Book id=" + getId() + "\n");
		sb.append("Book ISBN="+getIsbn()+ "\n");
		sb.append("Book Author="+getAuthor()+ "\n");
		sb.append("Book Title="+getTitle()+ "\n");
		sb.append("Book Year="+getYear()+ "\n");
		sb.append("\n");
		
		return sb.toString();
	}
	
	
	
}
