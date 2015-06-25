<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 07.06.2015
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
  <thread>
    <tr>
      <th>First name</th>
      <th>Last name</th>
      <th>Birth date</th>
    </tr>
  </thread>
  <tbody>
  <c:forEach items="${contacts}" var="contact">
    <tr>
      <td>${contact.firstName}</td>
      <td>${contact.lastName}</td>
      <td>${contact.birthDate}</td>
      <td><a href="delete/${contact.id}">delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
