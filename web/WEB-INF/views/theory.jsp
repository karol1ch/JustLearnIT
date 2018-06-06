<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Theory | JustLearnIT</title>
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

    <form:form modelAttribute="topic">
        <div class="card border-primary mb-3">
            <div class="card-header" style="text-align: center; font-size: 24px">${topic.name}</div>
            <div class="card-body">
                <p>${topic.theory}</p>
            </div>
            <div class="card-footer" align="center">
                <a class="btn btn-primary" href="/${topic.category.name}/example/${topic.id}" role="button">Example</a>
            </div>
        </div>
    </form:form>

</div>


</body>
</html>