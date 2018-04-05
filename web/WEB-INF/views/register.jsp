<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Welcome to register page</h1>

  <form action="/register" method="POST">
      <label for="email">E-mail</label>
      <input type="email" name="email" id="email"><br/>
      <label for="password">Password</label>
      <input type="password" name="password" id="password"><br/>
      <label for="repassword">Retype password</label>
      <input type="password" name="repassword" id="repassword"><br/>
    <input type="submit" name="Register" id="registerSubmit">
  </form>

  </body>
</html>
