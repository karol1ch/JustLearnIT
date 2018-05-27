<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard | JustLearnIT</title>
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
    <form:form modelAttribute="username">
        <h3 class="title">Hi ${username}! How are you?</h3>
    </form:form>

    </br></br>

    <div class="card border-primary mb-3">
        <div class="card-header" style="text-align: center; font-size: 24px">Recent categories</div>
        <div class="card-body">
            <div class="card-columns">
                <form:form modelAttribute="unfinishedCategories">
                    <c:forEach items="${unfinishedCategories}" var="unfinishedCategory">

                        <a href="/category/${unfinishedCategory.category.name}">
                            <div class="card">
                                <!-- <img class="card-img-top" src="..." alt="Card image cap"> -->
                                <div class="card-body">
                                    <h5 class="card-title">${unfinishedCategory.category.name}</h5>
                                    <p class="card-text">${unfinishedCategory.category.description}</p>
                                </div>
                            </div>
                        </a>

                    </c:forEach>
                </form:form>
            </div>
        </div>
        <div class="card-footer" style="text-align: center; font-size: 24px">Completed categories</div>
        <div class="card-body">
            <div class="card-columns">
                <form:form modelAttribute="completedCategories">
                    <c:forEach items="${completedCategories}" var="completedCategory">

                        <a href="/category/${completedCategory.category.name}">
                            <div class="card">
                                <!-- <img class="card-img-top" src="..." alt="Card image cap"> -->
                                <div class="card-body">
                                    <h5 class="card-title">${completedCategory.category.name}</h5>
                                    <p class="card-text">${completedCategory.category.description}</p>
                                </div>
                            </div>
                        </a>

                    </c:forEach>
                </form:form>
            </div>
        </div>
    </div>


</div>


</body>
</html>
