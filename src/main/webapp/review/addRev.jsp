<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/scripts.jsp" />
<link rel="stylesheet" type="text/css"
	href="../static/css/bootstrap.css">

<script>
	$(document)
			.ready(
					function() {
						$("#addRev")
								.on(
										'click',
										function(e) {
											e.preventDefault();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/api/reviews/add',
														type : 'POST',
														data : {
															book : document
																	.getElementById('book').value,
															revAuthor : document
																	.getElementById('revAuthor').value,
															text : document
																	.getElementById('text').value

														},
														success : function() {
															document.location
																	.replace("${pageContext.request.contextPath}/main");
														},
														error : function() {
															alert("Wrong data!");
														}
													});
										});
					});
</script>
</head>


<body>
	<div class="container">
		<div class="row">
			<h1 class="text-center">Add review</h1>
			<form action="${pageContext.request.contextPath}/api/reviews/add"
				method="post" data-toggle="validator" class="form-horizontal">

				<div class="form-group">
					<label for="book" class="col-sm-2 control-label">Book:</label>
					<div class="col-sm-10">
						<select name="book" id="book" class="form-control" required>
							<c:forEach var="selectedBook" items="${books}"
								varStatus="loopCounter">
								<option value="${selectedBook.id}">${selectedBook.getTitle()}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="revAuthor" class="col-sm-2 control-label">Author:</label>

					<div class="col-sm-10">
						<input type="text" name="revAuthor" id="revAuthor"
							class="form-control" required>
					</div>
				</div>

				<div class="form-group">
					<label for="text" class="col-sm-2 control-label">Review:</label>

					<div class="col-sm-10">
						<input type="text" name="text" id="text" class="form-control" />
					</div>
				</div>
				<div class="form-group text-center">
					<button id="addRev" type="submit" class="btn btn-success">Add</button>
					<a href="${pageContext.request.contextPath}/main"
						class="btn btn-default">Home page</a>
				</div>

			</form>
		</div>
	</div>
</body>
</html>