<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<link rel="stylesheet" type="text/css" href="../include/ksiegarnia.css">
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3>Edit review:</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/review/editRev/${review.id}" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="revAuthor" class="col-sm-2 control-label">Title:</label>

                    <div class="col-sm-10">
                        <input type="text" name="revAuthor" id="revAuthor" value="${review.revAuthor}" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="text" class="col-sm-2 control-label">Message:</label>

                    <div class="col-sm-10">
                        <input type="text" name="text" id="text" value="${review.text}" class="form-control">
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