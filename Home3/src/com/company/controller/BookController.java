package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BookDao;
import com.company.model.Book;

@WebServlet(name = "book", urlPatterns = "/book")
public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookDao bdao;

	public BookController() {
		super();

		bdao = new BookDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println(action);
		PrintWriter out = response.getWriter();

		if (action.equalsIgnoreCase("getSortBooks")) {
			String key = request.getParameter("key");
			String direction = request.getParameter("direction");
			List<Book> books = bdao.getSortBooks(direction, key);
			for (Book b : books) {
				out.print(b);
			}

		} else if (action.equalsIgnoreCase("getAllBooks")) {

			List<Book> books = bdao.getAllBooks();
			for (Book b : books) {
				out.print(b);
			}

		} else if (action.equalsIgnoreCase("getAllBooksByAuthor")) {
			String author = request.getParameter("author");
			System.out.println(author);
			List<Book> books = bdao.getAllBooksByAuthor(author);
			for (Book b : books) {
				out.print(b);
			}

		} else if (action.equalsIgnoreCase("getAllAuthors")) {

			List<String> authors = bdao.getAllAuthors();
			for (String a : authors) {
				out.println(a);
			}

		} else if (action.equalsIgnoreCase("getBooksByISBN")) {
			String isbn = request.getParameter("ISBN");
			System.out.println(isbn);
			Book book = bdao.getBooksByISBN(isbn);
			if (book != null) {
				out.print(book);
			} else if (action.equalsIgnoreCase("addBook")) {
				
				Book book1 = new Book();
				book1.setIsbn(request.getParameter("ISBN"));
				book1.setAuthor(request.getParameter("Author"));
				book1.setTitle(request.getParameter("Title"));
				book1.setYear(Integer.parseInt(request.getParameter("Year")));
				out.print(book1);
				bdao.addBook(book1);
				out.println("Book was added");

			}
		} else if (action.equalsIgnoreCase("deleteBook")) {
			request.getParameter("ISBN");

			int bookId = Integer.parseInt(request.getParameter("bookId"));

			bdao.deleteBook(bookId);
			out.println("Book was deleted");

		} else if (action.equalsIgnoreCase("updateBook")) {
			
			Book book1 = new Book();
			book1.setId(Integer.parseInt(request.getParameter("Id")));
			book1.setIsbn(request.getParameter("ISBN"));
			book1.setAuthor(request.getParameter("Author"));
			book1.setTitle(request.getParameter("Title"));
			book1.setYear(Integer.parseInt(request.getParameter("Year")));
			out.print(book1);
			bdao.updateBook(book1);
			out.println("Book was updated");

		}

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		PrintWriter out = response.getWriter();

		if (action.equalsIgnoreCase("getSortBooks")) {
			String key = request.getParameter("key");
			String direction = request.getParameter("direction");
			List<Book> books = bdao.getSortBooks(direction, key);
			for (Book b : books) {
				out.print(b);
			}

		} else if (action.equalsIgnoreCase("getAllBooks")) {

			List<Book> books = bdao.getAllBooks();
			for (Book b : books) {
				out.print(b);
			}

		} else if (action.equalsIgnoreCase("getAllBooksByAuthor")) {
			String author = request.getParameter("author");
			System.out.println(author);
			List<Book> books = bdao.getAllBooksByAuthor(author);
			for (Book b : books) {
				out.print(b);
			}

		} else if (action.equalsIgnoreCase("getAllAuthors")) {

			List<String> authors = bdao.getAllAuthors();
			for (String a : authors) {
				out.println(a);
			}

		} else if (action.equalsIgnoreCase("getBooksByISBN")) {
			String isbn = request.getParameter("ISBN");
			System.out.println(isbn);
			Book book = bdao.getBooksByISBN(isbn);
			if (book != null) {
				out.print(book);
			} else if (action.equalsIgnoreCase("addBook")) {
				
				Book book1 = new Book();
				book1.setIsbn(request.getParameter("ISBN"));
				book1.setAuthor(request.getParameter("Author"));
				book1.setTitle(request.getParameter("Title"));
				book1.setYear(Integer.parseInt(request.getParameter("Year")));
				out.print(book1);
				bdao.addBook(book1);
				out.println("Book was added");

			}
		} else if (action.equalsIgnoreCase("deleteBook")) {
			request.getParameter("ISBN");

			int bookId = Integer.parseInt(request.getParameter("bookId"));

			bdao.deleteBook(bookId);
			out.println("Book was deleted");

		} else if (action.equalsIgnoreCase("updateBook")) {
			
			Book book1 = new Book();
			book1.setId(Integer.parseInt(request.getParameter("Id")));
			book1.setIsbn(request.getParameter("ISBN"));
			book1.setAuthor(request.getParameter("Author"));
			book1.setTitle(request.getParameter("Title"));
			book1.setYear(Integer.parseInt(request.getParameter("Year")));
			out.print(book1);
			bdao.updateBook(book1);
			out.println("Book was updated");

		}
}
}