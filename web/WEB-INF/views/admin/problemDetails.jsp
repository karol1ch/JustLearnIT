<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Problem Details | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="../parts/adminMenu.jsp"/>

<div class="container">

    <form:form modelAttribute="problem">
        <div class="card border-primary mb-3">
            <div class="card-header" style="text-align: center; font-size: 24px">${problem.name}</div>
            <div class="card-body">
                <h5>Content:</h5>
                <p>${problem.content}</p>
                <h5>Input:</h5>
                <p>${problem.inputDescription}</p>
                <h5>Output:</h5>
                <p>${problem.outputDescription}</p>
            </div>
            <div class="card-header" style="text-align: center; font-size: 24px">Example</div>

            <div class="card-footer">
                <p>Author: <a href="/user/${problem.user.username}">${problem.user.username}</a></p>
            </div>
        </div>


    </form:form>

</div>


</body>
</html>