<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Categories Dashboard | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="parts/adminMenu.jsp" %>

<h2 class="text-center">Categories</h2>

<div class="form-row text-center">
    <div class="col-12">
        <a href="${pageContext.request.contextPath}/admin/addCategoryForm" class="btn btn-info" role="button">Add category</a>
    </div>
</div>

<br><br>
<div class="mx-auto" style="padding: 100px">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Category name</th>
            <th scope="col">Description</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>

        <form:form modelAttribute="categories">

            <c:forEach items="${categories}" var="category">
                <c:url var="deleteLink" value="/admin/deleteCategory">
                    <c:param name="categoryName" value="${category.name}"/>
                </c:url>
                <c:url var="updateLink" value="/admin/updateCategory">
                    <c:param name="categoryName" value="${category.name}"/>
                </c:url>
                <tr>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td><a href="${deleteLink}">Delete | </a>
                        <a href="${updateLink}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </form:form>

        </tbody>
    </table>
</div>

</body>
</html>
