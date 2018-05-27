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
        <div class="card-header" style="text-align: center; font-size: 24px">${categoryName}</div>
        <div class="card-body">${categoryDescription}</div>
        <div class="card-footer">
            <h5>Topics:</h5>
            <br>
            <ul class="list-group">
                <form:form modelAttribute="incompletedTopics">
                    <c:forEach items="${incompletedTopics}" var="topic">
                        <a href="/${categoryName}/theory/${topic.id}">
                            <li class="list-group-item list-group-item-primary">${topic.name}</li>
                        </a>
                    </c:forEach>
                </form:form>

            </ul>

            <br>

            <h5>Completed Topics:</h5>
            <br>
            <table class="table table-hover table-light">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th class="float-right" scope="col">Percentage</th>
                </tr>
                </thead>
                <tbody>
                <form:form modelAttribute="completedTopics">
                    <c:forEach items="${completedTopics}" var="completedTopic">
                        <tr class="table-success">
                            <td>
                                <a href="/${categoryName}/theory/${completedTopic.topic.id}">${completedTopic.topic.name}</a>
                            </td>
                            <td class="float-right">${completedTopic.percentageScore}</td>
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
