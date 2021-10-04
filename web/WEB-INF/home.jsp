<%-- 
    Document   : home
    Created on : Oct 4, 2021, 5:30:37 AM
    Author     : selva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html" />

<h1>Home</h1>

<p>Welcome!<br />
  You can manage your account from your profile.</p>

<form action="home" method="post">
  <input type="submit" value="Profile" class="margin_left" />
</form>

<c:import url="/includes/footer.jsp" />
