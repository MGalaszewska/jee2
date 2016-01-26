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
						$("#edit")
								.on(
										'click',
										function(e) {
											e.preventDefault();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/api/books/edit/${book.getId()}',
														type : 'PUT',
														data : {
															title : document
																	.getElementById('title').value,
															author : document
																	.getElementById('author').value,

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
			<div class="col-md-12">
				<h3>Edit book:</h3>
				<br />

				<form
					action="${pageContext.request.contextPath}/api/books/edit/${book.getId()}"
					method="post" data-toggle="validator" class="form-horizontal">
					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">Title:</label>

						<div class="col-sm-10">
							<input type="text" name="title" id="title"
								value="${book.getTitle()}" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label for="author" class="col-sm-2 control-label">Author:</label>

						<div class="col-sm-10">
							<input type="text" name="author" id="author"
								value="${book.getAuthor()}" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="edit" type="submit">Save</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<hr>

	</div>

</body>
</html>