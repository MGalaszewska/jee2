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
														url : '${pageContext.request.contextPath}/api/reviews/edit/${review.getId()}',
														type : 'PUT',
														data : {
															revAuthor : document
																	.getElementById('revAuthor').value,
															text : document
																	.getElementById('text').value,

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
				<h3>Edit review:</h3>
				<br />

				<form
					action="${pageContext.request.contextPath}/api/reviews/edit/${review.getId()}"
					method="post" data-toggle="validator" class="form-horizontal">
					<div class="form-group">
						<label for="revAuthor" class="col-sm-2 control-label">Author:</label>

						<div class="col-sm-10">
							<input type="text" name="revAuthor" id="revAuthor"
								value="${review.getRevAuthor()}" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label for="text" class="col-sm-2 control-label">Review:</label>

						<div class="col-sm-10">
							<input type="text" name="text" id="text"
								value="${review.getText()}" class="form-control">
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