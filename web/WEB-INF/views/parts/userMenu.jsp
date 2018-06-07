<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>


<nav class="navbar navbar-expand-sm bg-primary navbar-dark">

    <a class="navbar-brand" href="/">JustLearnIT</a>


    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/practice/categories">Practice</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Leaderboard</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="/learning/categories">Learning</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="/allSubmits">Submits</a>
        </li>


    </ul>

    <ul class="nav navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/userPanel">Profile</a>
        </li>
        <li class="nav-item">
            <form:form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="submit" value="Logout" class="btn btn-primary"/>
            </form:form>

        </li>
    </ul>

</nav>
<br>
<br>


