<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Dashboard</h1>
    <h2>Welcome ${username}, your password is ${password}</h2>

  <table>
      <tr>
          <td>id</td>
          <td>FirstName</td>
          <td>LastName</td>
          <td>Date of birth</td>
          <td>Username</td>
          <td>Password</td>

      </tr>
    <c:forEach var="person" items="${list_of_persons}">
     <tr>
         <td>${person.id}</td>
         <td>${person.firstName}</td>
         <td>${person.lastName}</td>
         <td>${person.dateOfBirth}</td>
         <td>${person.username}</td>
         <td>${person.password}</td>
     </tr>
    </c:forEach>
  </table>

   <form:form action="${pageContext.request.contextPath}/logout" method="post">
       <input type="submit" value="Logout" class="btn btn-primary"/>
   </form:form>

  </body>
</html>
