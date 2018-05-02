<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">JustLearnIT</a>

    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#">Practice</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Leaderboard</a>
        </li>

        <!-- Dropdown -->
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                Categories
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Easy</a>
                <a class="dropdown-item" href="#">Medium</a>
                <a class="dropdown-item" href="#">Hard</a>
            </div>
        </li>


    </ul>

    <ul class="nav navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link" href="#">Profile</a>
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
<br>




<div class="container">
    <div class="row my-2">
        <div class="col-lg-8 order-lg-2 ">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="" data-target="#profile" data-toggle="tab" class="nav-link active">Profile</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#edit" data-toggle="tab" class="nav-link">Edit Data</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#changeLogin" data-toggle="tab" class="nav-link">Edit Login</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#changePassword" data-toggle="tab" class="nav-link">Edit Password</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#changeAvatar" data-toggle="tab" class="nav-link">Edit Avatar</a>
                </li>
            </ul>
            <div class="tab-content py-4">

                <%-- Dane uzytkownika --%>

                <div class="tab-pane active" id="profile">
                    <h5 class="mb-3">User Profile</h5>
                    <div class="row">
                        <div class="col-md-9">

                            <div class=" col-md-9 col-lg-9 ">
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>Login:</td>
                                        <td>${username}</td>
                                    </tr>
                                    <tr>
                                        <td>First Name:</td>
                                        <td>${firstName}</td>
                                    </tr>
                                    <tr>
                                        <td>Last Name:</td>
                                        <td>${lastName}</td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td>${email}</td>
                                    </tr>
                                    <tr>
                                        <td>Gender:</td>
                                        <td>${gender}</td>
                                    </tr>
                                    <tr>
                                        <td>Country:</td>
                                        <td>${country}</td>
                                    </tr>
                                    <tr>
                                        <td>Member For:</td>
                                        <td>${howLong}</td>
                                    </tr>
                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div>
                    <!--/row-->
                </div>

                <%-- Zmiana danych --%>

                <div class="tab-pane" id="edit">
                    <form role="form">
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">First name</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="text"  name="firstName" >
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Last name</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="text"  name="lastName">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Email</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="email"  name="email">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Country</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="text"  name="country">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Gender</label>
                            <div class="col-lg-9">
                                <select class="form-control" size="0" name="gender">
                                    <option selected>Choose...</option>
                                    <option value="1"> Female</option>
                                    <option value="2"> Male</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label"></label>
                            <div class="col-lg-9">
                                <input type="submit" class="btn btn-primary" value="Save Changes">
                            </div>
                        </div>
                    </form>
                </div>

                <%-- Zmiana loginu --%>

                <div class="tab-pane" id="changeLogin">
                    <form role="form">
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Login</label>
                            <div class="col-lg-9">
                                <input type="text" class="form-control" name="username">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label"></label>
                            <div class="col-lg-9">
                                <input type="submit" class="btn btn-primary" value="Save Changes">
                            </div>
                        </div>
                    </form>
                </div>

                <%-- Zmiana hasla --%>

                <div class="tab-pane" id="changePassword">

                    <form role="form">
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Password</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" name="password">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Confirm password</label>
                            <div class="col-lg-9">
                                <input class="form-control" type="password" name="password">
                                <small id="passwordHelpInline" class="text-muted">
                                    Must be 8-20 characters long.
                                </small>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label"></label>
                            <div class="col-lg-9">
                                <input type="submit" class="btn btn-primary" value="Save Changes">
                            </div>
                        </div>
                    </form>
                </div>

                <%-- Zmiana avatara --%>

                <div class="tab-pane" id="changeAvatar">
                    <div class="col-lg-6 order-lg-1 text-center">
                        <img src="//placehold.it/150" class="mx-auto img-fluid img-circle d-block" alt="avatar">
                        <h6 class="mt-2">Upload a different photo</h6>
                        <label class="custom-file">
                            <input type="file" class="custom-file-input" id="customFile">
                            <label class="custom-file-label" for="customFile">Choose </label>
                        </label>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-lg-4 order-lg-1 text-center">
            <img src="//placehold.it/150" class="mx-auto img-fluid img-circle d-block" alt="avatar">
            <h5 class="mt-2">Admin - czerwony / Moderator - zielony  / User - niebieski</h5>
        </div>
    </div>
</div>



</body>
</html>
