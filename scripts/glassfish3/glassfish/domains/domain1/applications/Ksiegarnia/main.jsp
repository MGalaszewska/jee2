<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
</head>
<body>

	<div>
		<div>
			<h3>Books</h3>
			<br />

			<c:choose>
				<c:when test="${books.size() > 0}">
					<table class="zui-table zui-table-horizontal zui-table-highlight">
						<thead>
							<tr>
								<th>#</th>
								<th>Title</th>
								<th>Author</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${books}" varStatus="loopCounter">
								<tr>
									<td>${book.id}</td>
									<td>${book.title}</td>
									<td>${book.author}</td>
									<td><a href="book/view/${book.id}"> View </a> | <a
										href="edit/${book.id}"> Edit </a> | <a
										href="remove/${book.id}"> Remove </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</c:when>
				<c:otherwise>
					<div class="well">No books yet!</div>
				</c:otherwise>
			</c:choose>
		</div>

		<div>
			<div>
				<h3>Add new book!</h3>
				<br />

				<form action="add" method="post">
					<div>
						<label for="book">Title:</label>

						<div>
							<input type="text" name="title" id="title">
						</div>
					</div>

					<div>
						<label for="book">Author:</label>

						<div>
							<input type="text" name="author" id="author">
						</div>
					</div>

					<div>
						<div>
							<button type="submit">Add</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<hr>

	</div>

</body>
</html>