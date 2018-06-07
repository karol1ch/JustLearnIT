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
            <h5 class="mt-2"></h5>
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
                                <form:select  path="country" class="form-control">
                                    <form:option value="Albania"> Albania </form:option>
                                    <form:option value="Andorra"> Andorra </form:option>
                                    <form:option value="Austria"> Austria </form:option>
                                    <form:option value="Belarus"> Belarus </form:option>
                                    <form:option value="Bosnia and Herzegovina"> Bosnia and Herzegovina </form:option>
                                    <form:option value="Bulgaria"> Bulgaria </form:option>
                                    <form:option value="Croatia"> Croatia </form:option>
                                    <form:option value="Cyprus"> Cyprus </form:option>
                                    <form:option value="Czechia"> Czechia </form:option>
                                    <form:option value="Denmark"> Denmark </form:option>
                                    <form:option value="Estonia"> Estonia </form:option>
                                    <form:option value="Finland"> Finland </form:option>
                                    <form:option value="France"> France </form:option>
                                    <form:option value="Germany"> Germany </form:option>
                                    <form:option value="Great Britain"> Great Britain </form:option>
                                    <form:option value="Greece"> Greece </form:option>
                                    <form:option value="Hungary"> Hungary </form:option>
                                    <form:option value="Iceland"> Iceland </form:option>
                                    <form:option value="Ireland"> Ireland </form:option>
                                    <form:option value="Italy"> Italy </form:option>
                                    <form:option value="Latvia"> Latvia </form:option>
                                    <form:option value="Liechtenstein"> Liechtenstein </form:option>
                                    <form:option value="Lithuania"> Lithuania </form:option>
                                    <form:option value="Luxembourg"> Luxembourg </form:option>
                                    <form:option value="Macedonia"> Macedonia </form:option>
                                    <form:option value="Malta"> Malta </form:option>
                                    <form:option value="Moldova"> Moldova </form:option>
                                    <form:option value="Monaco"> Monaco </form:option>
                                    <form:option value="Montenegro"> Montenegro </form:option>
                                    <form:option value="Netherlands"> Netherlands </form:option>
                                    <form:option value="Norway"> Norway </form:option>
                                    <form:option value="Poland"> Poland </form:option>
                                    <form:option value="Portugal"> Portugal </form:option>
                                    <form:option value="Romania"> Romania </form:option>
                                    <form:option value="Russia"> Russia </form:option>
                                    <form:option value="San Marino"> San Marino </form:option>
                                    <form:option value="Serbia"> Serbia </form:option>
                                    <form:option value="Slovakia"> Slovakia </form:option>
                                    <form:option value="Slovenia"> Slovenia </form:option>
                                    <form:option value="Spain"> Spain </form:option>
                                    <form:option value="Sweden"> Sweden </form:option>
                                    <form:option value="Switzerland"> Switzerland </form:option>
                                    <form:option value="Turkey"> Turkey </form:option>
                                    <form:option value="Ukraine"> Ukraine </form:option>
                                    <form:option value="Vatican"> Vatican </form:option>
                                </form:select>
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
