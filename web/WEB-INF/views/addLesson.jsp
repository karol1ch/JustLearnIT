<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Add Lesson | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>

<body>

<jsp:include page="./parts/adminMenu.jsp"/>
<div style="padding: 20px">
    <form:form modelAttribute="lesson" action="saveLesson" method="get" enctype="multipart/form-data">

        Name:
        <form:input path="name"/>
        <br/>
        <br/>
        Theory:
        <br/>
        <form:textarea path="theory" rows="10" cols="100"/>
        <br/>

        Code Example:
        </br>
        <form:textarea path="codeExample" rows="10" cols="100"/>
        </br>

        Code Explanation:
        <br>
        <form:textarea path="codeExplanation" rows="10" cols="100"/>
        <br>

        Category:
        <form:select path="category.name">
            <form:options items="${categories}"/>
        </form:select>

        <br/>
        <button type="submit" class="btn btn-primary"> Submit</button>

    </form:form>
</div>

</body>
</html>
