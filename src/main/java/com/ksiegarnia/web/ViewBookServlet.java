package com.ksiegarnia.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.domain.Book;
import com.ksiegarnia.service.BookManager;

@WebServlet(urlPatterns = "/BookDetails/*")
public class ViewBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static Long idToDelete;

	@EJB
	private BookManager bookStorage = new BookManager();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long id = WebUtils.getBookID(request);

		Book book = bookStorage.getBook(id);

		request.setAttribute("bookID", id);
		request.setAttribute("reviews", book.getReviews());

		idToDelete = id;
		request.getRequestDispatcher("/book/view.jsp").forward(request,
				response);
	}
}