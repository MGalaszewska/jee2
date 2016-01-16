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

@WebServlet(urlPatterns = "/view/*")
public class ViewBookServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
    private BookManager bookStorage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookID = WebUtils.getBookID(request);

        Book book = bookStorage.get(bookID);
        
        request.setAttribute("book", book);
<<<<<<< HEAD
        //request.setAttribute("reviews", book.getReviews());
=======
        request.setAttribute("reviews", book.getReviews());
>>>>>>> 4b000221e130c42ce7dda85345a7fae63bdeb0a0
        request.getRequestDispatcher("/book/view.jsp").forward(request, response);
    }
}