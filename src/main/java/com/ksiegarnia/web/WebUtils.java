package com.ksiegarnia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {
	public static Long getBookID(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		String bookID = pathInfo.substring(pathInfo.lastIndexOf("/") + 1,
				pathInfo.length());
		return Long.valueOf(bookID);
	}

	public static Long getReviewID(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		String reviewID = pathInfo.substring(pathInfo.lastIndexOf("/") + 1,
				pathInfo.length());

		return Long.valueOf(reviewID);
	}

	public static void redirectToMainPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.sendRedirect(response.encodeRedirectURL(request
				.getContextPath() + "/main"));
	}

	public static void redirectToBookView(HttpServletRequest request,
			HttpServletResponse response, Long id) throws IOException {
		response.sendRedirect(response.encodeRedirectURL(request
				.getContextPath() + "/view/" + id));
	}

}