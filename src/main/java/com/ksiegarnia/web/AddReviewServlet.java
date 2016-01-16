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
<<<<<<< HEAD
		String author = request.getParameter("revAuthor");

		Review review = new Review();
		review.setText(reviewText);
		review.setRevAuthor(author);
=======
		String revAuthor = request.getParameter("revAuthor");

		Review review = new Review();
		review.setText(reviewText);
		review.setRevAuthor(revAuthor);
>>>>>>> 4b000221e130c42ce7dda85345a7fae63bdeb0a0
		review.setAddDate(new Date());

		bookStorage.addReview(book, review);

		response.sendRedirect(response.encodeRedirectURL(request
<<<<<<< HEAD
				.getContextPath() + "/view/" + bookID));
=======
				.getContextPath() + "/book/view/" + bookID));
>>>>>>> 4b000221e130c42ce7dda85345a7fae63bdeb0a0
	}
}