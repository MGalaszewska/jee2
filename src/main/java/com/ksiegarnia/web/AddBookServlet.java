package com.ksiegarnia.web;
import com.ksiegarnia.service.BookManager;
import com.ksiegarnia.domain.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class AddBookServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
    private BookManager bookStorage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);

        bookStorage.addBook(newBook);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }
}