package com.ksiegarnia.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.service.BookManager;

@WebServlet(urlPatterns = "/BookRemove/*")
public class RemoveBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	private BookManager bookStorage;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long id = WebUtils.getBookID(request);

		bookStorage.deleteBook(id);

		WebUtils.redirectToMainPage(request, response);
	}
}