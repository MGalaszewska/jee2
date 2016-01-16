<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body>


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3>Edit book:</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/edit/${book.id}" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">Title:</label>

                    <div class="col-sm-10">
                        <input type="text" name="title" id="title" value="${book.title}" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">Message:</label>

                    <div class="col-sm-10">
                        <input type="text" name="author" id="author" value="${book.author}" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <hr>

</div>

</body>
</html>