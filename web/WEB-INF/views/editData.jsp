<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>UserPanel | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <style type="text/css">
        .error {
            color: red;
        }
    </style>

</head>


<jsp:include page="./parts/userMenu.jsp"/>

<div class="container">
    <div class="row my-2">
        <div class="col-lg-4 order-lg-1 text-center">
            <img src="//placehold.it/150" class="mx-auto img-fluid img-circle d-block" alt="avatar">
            <h5 class="mt-2">Admin - czerwony / Moderator - zielony  / User - niebieski</h5>
        </div>
        <div class="col-lg-8 order-lg-2 ">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="/userPanel" class="nav-link">Profile</a>
                </li>
                <li class="nav-item">
                    <a href="/editData" class="nav-link active">Edit Data</a>
                </li>
                <li class="nav-item">
                    <a href="/editPassword" class="nav-link">Edit Password</a>
                </li>
            </ul>

            <div class="tab-content py-4">
                <div class="tab-pane active">
                    <form:form action="/updateData" modelAttribute="userDetail" method="POST">
                        <form:hidden path="username" />

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">First name</label>
                            <div class="col-lg-9">
                                <form:input path="firstName" class="form-control"/>
                                <form:errors path="firstName" cssClass="error"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Last name</label>
                            <div class="col-lg-9">
                                <form:input path="lastName" class="form-control"/>
                                <form:errors path="lastName" cssClass="error"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Email</label>
                            <div class="col-lg-9">
                                <form:input path="email" class="form-control"/>
                                <c:if test="${message != null}">
                                    <div class="error">
                                            ${message}
                                    </div>
                                </c:if>
                                <form:errors path="email" cssClass="error"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Country</label>
                            <div class="col-lg-9">
                                <form:input path="country" class="form-control"/>
                                <form:errors path="country" cssClass="error"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label"></label>
                            <div class="col-lg-9">
                                <input type="submit" class="btn btn-primary" id="btn-edit" value="Save Changes">
                            </div>
                        </div>
                    </form:form>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
