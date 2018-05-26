<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Submit Result | JustLearnIT</title>
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
        <div class="card-header" style="text-align: center; font-size: 24px">Submit: ${submitID}</div>
        <div class="card-body">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col">Test Number</th>
                    <th scope="col">Execution Time</th>
                    <th scope="col">Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${results}" var="result">
                    <c:choose>
                        <c:when test="${result.status == 'Passed'}">
                            <tr class="table-success">
                                <th scope="row">${result.test.number}</th>
                                <td>${result.executionTimeMs}</td>
                                <td>${result.status}</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr class="table-danger">
                                <th scope="row">${result.test.number}</th>
                                <td>${result.executionTimeMs}</td>
                                <td>${result.status}</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                    <tr class="${result.status == "Passed" ? " table-success" : "table-danger"}">

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="card-footer">
            <jsp:include page="parts/ideReadOnly.jsp"/>
        </div>
    </div>
</div>

</body>

</html>