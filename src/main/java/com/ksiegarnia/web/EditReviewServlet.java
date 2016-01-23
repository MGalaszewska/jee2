package com.ksiegarnia.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksiegarnia.service.BookManager;

@WebServlet(urlPatterns = "/review/editRev/*")
public class EditReviewServlet extends HttpServlet{
    @EJB
    private BookManager bookStorage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long reviewID = WebUtils.getReviewID(request);
        

        request.setAttribute("review", bookStorage.getRev(reviewID));
        request.getRequestDispatcher("/review/editRev.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String revAuthor = request.getParameter("revAuthor");
        String text = request.getParameter("text");
        //data?
        Long reviewID = WebUtils.getReviewID(request);

        bookStorage.updateReview(reviewID, revAuthor, text);

        WebUtils.redirectToMainPage(request, response);
    }
}