<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit Your Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<h1>Edit Your Ad</h1>
<br>
<a href="/profile" class="btn btn-default btn-return">Return to Profile</a>
<div class="form-container">
    <div class="input-container">
        <form action="/ad/edit" method="POST">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
                <c:if test="${adErrors.containsKey('title')}">
                    <span class="errors">${adErrors.get('title')}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input id="description" name="description" class="form-control" type="text" value="${ad.description}">
                <c:if test="${adErrors.conatainsKey('description')}">
                    <span class="errors">${ad.Errors.get('description')}</span>
                </c:if>
            </div>
            <input type="hidden" name="id" value="${ad.id}">
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</div>

</body>
</html>