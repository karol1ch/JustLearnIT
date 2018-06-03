<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style type="text/css">
    .error {
        color: red;
    }
</style>


<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title">Sign Up</div>

            </div>

            <div style="padding-top:30px" class="panel-body" >

                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                <form:form class="form-horizontal" modelAttribute="user" action="${pageContext.request.contextPath}/submitRegistrationForm" method="POST">


                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <%--<input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username">--%>
                        <form:input path="username" class="form-control" placeholder="username"/>
                        <form:errors path="username" cssClass="error"/>
                    </div>


                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <%--<input id="login-email" type="text" class="form-control" name="username" value="" placeholder="email">--%>
                        <form:input path="userDetailByUsername.email" class="form-control" placeholder="email"/>
                        <form:errors path="userDetailByUsername.email" cssClass="error"/>
                    </div>



                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <%--<input id="login-password" type="password" class="form-control" name="password" placeholder="password">--%>
                        <form:input path="password" type="password" class="form-control" placeholder="password"/>
                        <form:errors path="password" cssClass="error"/>
                    </div>



                    <button type="submit" class="btn btn-success">Sign up!</button>
                </form:form>



            </div>
        </div>
    </div>




</div>
</div>
