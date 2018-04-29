<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Problems Dashboard | JustLearnIT</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="parts/adminMenu.jsp" %>

<h2 class="text-center">Problems</h2>

<div class="form-row text-center">
    <div class="col-12">
        <a href="#" class="btn btn-info" role="button">Add problem</a>
    </div>
</div>

<br><br>
<div class="mx-auto" style="padding: 100px">
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Problem title</th>
        <th scope="col">Problem short description</th>
        <th scope="col">Category</th>
        <th scope="col">Points</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>Welcome to Java!</td>
        <td>How to write "Hello World!" in Java</td>
        <td>Java</td>
        <td>5</td>
        <td><a href="#">Delete</a></td>
    </tr>
    <tr>
        <th scope="row">2</th>
        <td>Integers in Java</td>
        <td>Using integers in Java</td>
        <td>Java</td>
        <td>7</td>
        <td><a href="#">Delete</a></td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td>First String in Java</td>
        <td>Get String input and output</td>
        <td>Java</td>
        <td>10</td>
        <td><a href="#">Delete</a></td>
    </tr>

    </tbody>
</table>
</div>

</body>
</html>
