<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>
<link rel="stylesheet" type="text/css" href="../include/ksiegarnia.css">
<body>
<div>
 <h3>Books</h3>
        <br/>

         <label>Title:</label>
        ${book.title} <br/>

        <label>Author:</label>
        ${book.author} <br/>
        
</div>
<hr>
<p>Reviews:</p>
        <div class="well">
            <c:choose>
                <c:when test="${reviews.size() > 0}">
                    <c:forEach var="review" items="${reviews}" varStatus="loop">
                        <p>Date: ${review.revAuthor}</p>
                        <p>Author: ${review.addDate}</p>
                        <p>${review.text}</p>
						<p><a href="../review/editRev/${review.id}"> Edit </a>
						<p><a href="../review/removeReview/${review.id}"> Delete </a>
						
                        <c:if test="${!loop.last}">
                            <hr />
                        </c:if>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    No reviews yet!
                </c:otherwise>
            </c:choose>
        </div>
        
<hr>

    <div class="row">
        <div class="col-md-12">
            <h3>Add review:</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/reviews/add/${book.id}" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="revAuthor" class="col-sm-2 control-label">Author:</label>

                    <div class="col-sm-10">
                        <input type="text" name="revAuthor" id="revAuthor" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="text" class="col-sm-2 control-label">Message:</label>

                    <div class="col-sm-10">
                        <input type="text" name="text" id="text" class="form-control">
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

</body>
</html>
