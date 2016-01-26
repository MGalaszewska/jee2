package com.ksiegarnia.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.service.BookManager;

@WebServlet(urlPatterns = "/AddBook")
public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private BookManager bookStorage = new BookManager();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/book/add.jsp")
				.forward(request, response);
	}
}