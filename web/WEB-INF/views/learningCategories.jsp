<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Learning Categories | JustLearnIT</title>
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
        <div class="card-header" style="text-align: center; font-size: 24px">Learning Categories</div>
        <div class="card-body">
            <form:form modelAttribute="categories">
                <c:forEach items="${categories}" var="category">

                    <a href="/learning/category/${category.name}" class="list-group-item list-group-item-action flex-column align-items-start" style="margin: 16px">
                        <h5 style="text-align: center; font-size: 24px">${category.name}</h5>
                        <p class="mb-1" style="text-align: center">${category.description}</p>
                    </a>

                </c:forEach>
            </form:form>
        </div>
        <div class="card-footer">

        </div>
    </div>

</div>



</body>
</html>