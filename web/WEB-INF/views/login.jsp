<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Welcome to login page!</h1>
  <button type="button">Login with Google Account</button><br/>
  <button type="button">Login with Facebook Account</button><br/>
  <h2>Login traditionally:</h2>
  <form action="/login" method="POST">
      <label for="username">Username</label>
      <input type="text" name="username" id="username"><br/>
      <label for="password">Password</label>
      <input type="password" name="password" id="password"><br/>
      <input type="submit" name="Login" id="loginSubmit">
  </form>


  </body>
</html>
