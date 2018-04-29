<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Dashboard | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="parts/adminMenu.jsp" %>
<h2 class="text-center">Dashboard</h2>
<br>


<div style="padding-left: 200px; padding-right: 200px   ">
    <form>

        <div class="form-group">
            <label for="exampleFormControlTextarea1">Title</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="1"></textarea>
        </div>


        <div class="form-group">
            <label for="exampleFormControlTextarea1">Description</label>
            <textarea class="form-control" id="exampleFormControlTextarea2" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>


<br>
<div class="card">
    <div class="card-header">
        Added admin dashboard
    </div>
    <div class="card-body">
        <p class="card-text">In this version admin dashboard with problems' site has been added</p>
    </div>
</div>

<br>


</body>
</html>
