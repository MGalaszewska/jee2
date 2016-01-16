package com.ksiegarnia.web;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.service.BookManager;

import java.io.IOException;

@WebServlet(urlPatterns = "/view/*")
public class ViewBookServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
    private BookManager bookStorage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookID = WebUtils.getBookID(request);

        request.setAttribute("book", bookStorage.get(bookID));
        request.getRequestDispatcher("/book/view.jsp").forward(request, response);
    }
}