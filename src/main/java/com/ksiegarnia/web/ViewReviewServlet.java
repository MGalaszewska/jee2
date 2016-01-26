package com.ksiegarnia.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.service.BookManager;

@WebServlet(urlPatterns = "/ReviewDetails/*")
public class ViewReviewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private BookManager bookStorage = new BookManager();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long id = WebUtils.getReviewID(request);

		request.setAttribute("reviewID", id);
		request.getRequestDispatcher("/review/viewRev.jsp").forward(request,
				response);
	}
}