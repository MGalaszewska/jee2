package com.ksiegarnia.web;

import com.ksiegarnia.service.BookManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/main")
public class MainBookServlet extends HttpServlet{
	@EJB
    private BookManager bookStorage;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("books", bookStorage.getAllBook());
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}