<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Problem tests | JustLearnIT</title>
</head>
<body>


<div class="container">

    <div class="card border-primary mb-3">
        <div class="card-header" style="text-align: center; font-size: 24px">Learning Categories</div>
        <div class="card-body">
            <form:form modelAttribute="tests">
                <c:forEach items="${tests}" var="test">

                    <a href="/learning/category/${category.name}" class="list-group-item list-group-item-action flex-column align-items-start" style="margin-bottom: 16px; margin-top: 16px">
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
