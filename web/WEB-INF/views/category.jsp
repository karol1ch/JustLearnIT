<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${categoryName} | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="./parts/userMenu.jsp"/>

<div class="container">
    <div class="card border-primary mb-3">
        <form:form modelAttribute="category">
            <div class="card-header" style="text-align: center; font-size: 24px">${category.name}</div>
            <div class="card-body">
                <p>${category.description}</p>
            </div>
        </form:form>
        <div class="card-footer">
            <table class="table table-hover table-light">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Users</th>
                    <th scope="col">Difficulty</th>
                </tr>
                </thead>
                <tbody>
                <form:form modelAttribute="problems">
                    <c:forEach items="${problems}" var="problem">
                        <tr>
                            <th scope="row">${problem.id}</th>
                            <td><a href="/${categoryName}/problem/${problem.id}">${problem.name}</a></td>
                            <td>${problem.numberOfAcceptedSolutions}</td>
                            <td>${problem.difficulty}</td>
                        </tr>
                    </c:forEach>
                </form:form>
                </tbody>
            </table>
        </div>
    </div>
</div>






</body>
</html>