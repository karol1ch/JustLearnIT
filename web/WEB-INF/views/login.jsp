<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title">Sign In</div>
                <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
            </div>

            <div style="padding-top:30px" class="panel-body" >

                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                <form:form id="loginform" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/authTheUser" method="POST">


                    <c:if test="${param.error != null}">

                        <div class="alert alert-danger" role="alert">
                            Invalid username or password.
                        </div>
                    </c:if>

                    <c:if test="${param.logout != null}">
                        <div class="alert alert-success" role="alert">
                            You have been logged out.
                        </div>

                    </c:if>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username">

                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                    </div>





                    <div style="margin-top:10px" class="form-group">


                        <div class="col-sm-12 controls">

                            <input type="submit" value="Login" id="btn-login" class="btn btn-success">
                            <a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>

                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-md-12 control">
                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                Don't have an account!
                                <a href="#" onClick="alert('Sign Up need to be implemented')">
                                    Sign Up Here
                                </a>
                            </div>
                        </div>
                    </div>
                </form:form>



            </div>
        </div>
    </div>




</div>
</div>
