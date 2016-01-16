<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body>

<div class="container">
    <div class="row">
        <h3>Book</h3>
        <br/>

        <p>Title:</p>
        <div class="well well-sm">${book.title}</div>

        <p>Author:</p>
        <div class="well well-sm">${book.author}</div>
        
    </div>

    <hr>

</div>

</body>
</html>