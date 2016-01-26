<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="include/scripts.jsp" />
<link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">

<script>
	$(document)
			.ready(
					function() {
						$
								.ajax({
									url : '${pageContext.request.contextPath}/api/books/showall',
									type : 'GET',
									success : function(dane) {
										var d = dane.length;
										var table = document
												.getElementById("table");
										for (var i = 0; i < d; i++) {
											tr = $('<tr/>');
											tr.append("<td>" + dane[i].title
													+ "</td>");
											tr.append("<td>" + dane[i].author
													+ "</td>");
											td = $('<td/>');
											td
													.append("<a href='${pageContext.request.contextPath}/BookDetails/"+dane[i].id+"' class='btn btn-xs btn-warning' role='button'> Details </a> ");
											tr.append(td);
											td = $('<td/>');
											td
													.append("<a href='${pageContext.request.contextPath}/BookEdit/"+dane[i].id+"' class='btn btn-xs btn-warning' role='button'> Edit </a> ");
											tr.append(td);
											td = $('<td/>');
											td
													.append("<a href='${pageContext.request.contextPath}/BookRemove/"+dane[i].id+"' class='btn btn-xs btn-warning' role='button'> Remove </a> ");
											tr.append(td);
											$(table).append(tr);
										}
									}
								});
					});
</script>

</head>
<body>
	<div>
		<div>
			<h1>Books</h1>
			<div>
				<a href="${pageContext.request.contextPath}/AddBook">Add book</a> 
				<a href="${pageContext.request.contextPath}/AddReview">Add review</a>
			</div>
			<br />

			<table id="table">
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th></th>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>