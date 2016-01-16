package com.ksiegarnia.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.service.BookManager;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet(urlPatterns = "/edit/*")
public class EditBookServlet extends HttpServlet{
    @EJB
    private BookManager bookStorage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookID = WebUtils.getBookID(request);

        request.setAttribute("book", bookStorage.get(bookID));
        request.getRequestDispatcher("/book/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author= request.getParameter("author");
        Long bookID = WebUtils.getBookID(request);

        bookStorage.updateBook(bookID, title, author);

        WebUtils.redirectToBookView(request, response, bookID);
    }
}