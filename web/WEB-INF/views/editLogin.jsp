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
                    <a href="/userPanel" class="nav-link ">Profile</a>
                </li>
                <li class="nav-item">
                    <a href="/editData" class="nav-link">Edit Data</a>
                </li>
                <li class="nav-item">
                    <a href="/editLogin" class="nav-link active">Edit Login</a>
                </li>
                <li class="nav-item">
                    <a href="/editPassword" class="nav-link">Edit Password</a>
                </li>
                <li class="nav-item">
                    <a href="/editAvatar" class="nav-link">Edit Avatar</a>
                </li>
            </ul>
            <div class="tab-content py-4">
                <div class="tab-pane active">
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

            </div>
        </div>
    </div>
</div>



</body>
</html>