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
                    <a href="/userPanel" class="nav-link active">Profile</a>
                </li>
                <li class="nav-item">
                    <a href="/editData" class="nav-link">Edit Data</a>
                </li>
                <li class="nav-item">
                    <a href="/editPassword" class="nav-link">Edit Password</a>
                </li>
            </ul>
            <div class="tab-content py-4">


                <div class="tab-pane active">
                    <h5 class="mb-3">User Profile</h5>
                    <div class="row">
                        <div class="col-md-9">

                            <div class=" col-md-9 col-lg-9 ">
                                <form:form modelAttribute="userDetail">
                                    <table class="table table-user-information">
                                        <tbody>
                                        <tr>
                                            <td>Login:</td>
                                            <td>${userDetail.username}</td>
                                        </tr>
                                        <tr>
                                            <td>First Name:</td>
                                            <td>${userDetail.firstName}</td>
                                        </tr>
                                        <tr>
                                            <td>Last Name:</td>
                                            <td>${userDetail.lastName}</td>
                                        </tr>
                                        <tr>
                                            <td>Email:</td>
                                            <td>${userDetail.email}</td>
                                        </tr>
                                        <tr>
                                            <td>Country:</td>
                                            <td>${userDetail.country}</td>
                                        </tr>
                                        <tr>
                                            <td>Member For:</td>
                                            <td>${howLong}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </form:form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



</body>
</html>
