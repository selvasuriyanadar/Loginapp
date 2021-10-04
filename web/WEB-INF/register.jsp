<%-- 
    Document   : register
    Created on : Oct 4, 2021, 5:30:16 AM
    Author     : selva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html" />

<h1>Register</h1>

<p>Please provide the required details to create your account.</p>

<c:if test="${message != null}">
  <p><i>${message}</i></p>
</c:if>

<form action="register" method="post">
  <label class="pad_top">User Name:</label>
  <input type="text" name="userName" /><br />
  <label class="pad_top">Password:</label>
  <input type="text" name="password" /><br />
  <label>&nbsp;</label>
  <input type="submit" value="Register" class="margin_left" />
</form>

<c:import url="/includes/footer.jsp" />
