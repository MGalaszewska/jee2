package com.ksiegarnia.web;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.domain.Book;
import com.ksiegarnia.domain.Review;
import com.ksiegarnia.service.BookManager;

@WebServlet(urlPatterns = "/reviews/add/*")
public class AddReviewServlet extends HttpServlet {
	@EJB
	private BookManager bookStorage;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long bookID = WebUtils.getBookID(request);
		Book book = bookStorage.get(bookID);

		String reviewText = request.getParameter("text");
		String revAuthor = request.getParameter("revAuthor");

		Review review = new Review();
		review.setRevAuthor(revAuthor);
		review.setText(reviewText);
		review.setAddDate(new Date());
		bookStorage.addReview(book, review);

		response.sendRedirect(response.encodeRedirectURL(request
				.getContextPath() + "/view/" + bookID));
	}
}
