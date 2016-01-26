<%@ page contentType="text/html;charset=UTF-8" language="java"%>

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
						$("#add")
								.on(
										'click',
										function(e) {
											e.preventDefault();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/api/books/add',
														type : 'POST',
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
				<h1>Add book</h1>

				<form action="${pageContext.request.contextPath}/api/books/add"
					method="post" data-toggle="validator" class="form-horizontal">
					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">Title:</label>

						<div class="col-sm-10">
							<input type="text" name="title" id="title" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label for="author" class="col-sm-2 control-label">Author:</label>

						<div class="col-sm-10">
							<input type="text" name="author" id="author" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<button id="add" type="submit" class="btn btn-success">Add</button>
					</div>
					<div class="form-group text-center">
						<a href="${pageContext.request.contextPath}/main"
							class="btn btn-default" role="button">Home page</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>