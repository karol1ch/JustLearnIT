<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Problems Dashboard | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="parts/adminMenu.jsp" %>

<h2 class="text-center">Problems</h2>

<div class="form-row text-center">
    <div class="col-12">
        <a href="${pageContext.request.contextPath}/admin/addProblem" class="btn btn-info" role="button">Add problem</a>
    </div>
</div>

<br><br>
<div class="mx-auto" style="padding: 100px">
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Problem Name</th>
        <th scope="col">Author</th>
        <th scope="col">Category</th>
        <th scope="col">Content</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>

    <form:form modelAttribute="problems">

        <c:forEach items="${problems}" var="problem">
            <c:url var="deleteLink" value="/admin/deleteProblem">
                <c:param name="problemId" value="${problem.id}"/>
            </c:url>
            <c:url var="updateLink" value="/admin/updateProblem">
                <c:param name="problemId" value="${problem.id}"/>
            </c:url>
            <c:url var="detailsLink" value="/admin/problemDetails/${problem.id}">
                <c:param name="problemId" value="${problem.id}"/>
            </c:url>

    <tr>
        <th scope="row">${problem.id}</th>
        <td>${problem.name}</td>
        <td>${problem.user.username}</td>
        <td>${problem.category.name}</td>
        <td>${problem.content}</td>
        <td><a href="${deleteLink}">Delete | </a>
            <a href="${updateLink}">Update</a>
            <a href="${detailsLink}">Details</a>
        </td>
    </tr>
        </c:forEach>
    </form:form>

    </tbody>
</table>
</div>

</body>
</html>
