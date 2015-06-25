<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 15.06.2015
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="new" method="post">
  Login: <input type="text" name="login"><br/>
  Password: <input type="password" name="password"><br/>
  First Name: <input type="text" name="firstName"><br/>
  Last Name: <input type="text" name="lastName"><br/>
  <%--Date of birth: <input type="date" name="birthDate"><br/>--%>
  <input type="submit" name="register" value="Registration">
</form>
</body>
</html>
