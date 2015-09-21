package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Book;
import com.company.util.DbUtil;

public class BookDao {

	private Connection connection;

	public BookDao() {
		connection = DbUtil.getConnection();
	}

	public void addBook(Book book) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO books (ISBN,Author,Title,Year) values (?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getTitle());
			preparedStatement.setInt(4, book.getYear());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook(int bookId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from books where Id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, bookId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBook(Book book) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update books set ISBN=?, Author=?, Title=?, Year=?" +
							"where userid=?");
			// Parameters start with 1
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getTitle());
			preparedStatement.setInt(4, book.getYear());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books");
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("Id"));
				book.setIsbn(rs.getString("ISBN"));
				book.setAuthor(rs.getString("Author"));
				book.setTitle(rs.getString("Title"));
				book.setYear(rs.getInt("Year"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}
	
	
	public List<String> getAllAuthors() {
		List<String> authors = new ArrayList<String>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select Author from books");
			while (rs.next()) {
				authors.add(rs.getString("Author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return authors;
	}
	
	public List<Book> getAllBooksByAuthor(String author) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from books where Author =?");
			// Parameters start with 1
			preparedStatement.setString(1, author);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("Id"));
				book.setIsbn(rs.getString("ISBN"));
				book.setAuthor(rs.getString("Author"));
				book.setTitle(rs.getString("Title"));
				book.setYear(rs.getInt("Year"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public Book getBooksByISBN(String isbn) {
		Book book = new Book();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from books where ISBN =? Limit 1 ");
			// Parameters start with 1
			preparedStatement.setString(1, isbn);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()){
				
				book.setId(rs.getInt("Id"));
				book.setIsbn(rs.getString("ISBN"));
				book.setAuthor(rs.getString("Author"));
				book.setTitle(rs.getString("Title"));
				book.setYear(rs.getInt("Year"));
				
			}else{
				book = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public List<Book> getSortBooks(String direction, String key) {
		List<Book> books = new ArrayList<Book>();
		String query = "select * from books order by " + key + " "+direction;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			// Parameters start with 1
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("Id"));
				book.setIsbn(rs.getString("ISBN"));
				book.setAuthor(rs.getString("Author"));
				book.setTitle(rs.getString("Title"));
				book.setYear(rs.getInt("Year"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}
}
