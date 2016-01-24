<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../include/scripts.jsp" />

<script>
		$(document).ready(function()
			{
				$( "#add" ).on('click', function(e)
					{	
						e.preventDefault();
						$.ajax
						(
						{
						    url: '${pageContext.request.contextPath}/api/books/add',
						    type: 'POST',
						    data:
							{
								title: document.getElementById('title').value,
								author: document.getElementById('author').value,
								
							},
						    success: function() { document.location.replace("${pageContext.request.contextPath}/main"); },
 						    error: function() { alert("Wrong data!"); }
						}		
						);
					}
				);
			}
		);
	</script>




</head>
<body>

<div>
    <div>
        <h1>Add book</h1>

        	<form action="${pageContext.request.contextPath}/api/books/add" data-toggle="validator" method="post">
		        <div>
		            <label for="title">Title:</label>

		            <div>
		                <input type="text" name="title" id="title">
		            </div>
		        </div>

		        <div>
		            <label for="author">Author:</label>

		            <div>
		                <input type="text" name="author" id="author">
		            </div>
		        </div>
		        <div>
		                <button id="add" type="submit">Add</button>
		 	    </div>
		 	    <div>
        	<a href="${pageContext.request.contextPath}/main">Home page</a>
         </div>
            	</form>
</div>
</div>

</body>
</html>