<%-- 
    Document   : login
    Created on : Oct 4, 2021, 5:26:08 AM
    Author     : selva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html" />

<h1>Login</h1>

<p>Please log into your account.</p>

<c:if test="${message != null}">
  <p><i>${message}</i></p>
</c:if>

<form action="" method="post">
  <input type="hidden" name="action" value="login" />
  <label class="pad_top">User Name:</label>
  <input type="text" name="userName"
    value='<%=(request.getParameter("userName") == null)? "": request.getParameter("userName")%>' /><br />
  <label class="pad_top">Password:</label>
  <input type="password" name="password"
    value='<%=(request.getParameter("password") == null)? "": request.getParameter("password")%>' /><br />
  <label>&nbsp;</label>
  <input type="submit" value="Login" class="margin_left" />
</form>

<p>Don't have an account!<br />
  You can quikly register a new account.</p>

<form action="" method="post">
  <input type="hidden" name="action" value="register" />
  <input type="submit" value="Register New" class="margin_left" />
</form>

<c:import url="/includes/footer.jsp" />
