<%-- 
    Document   : profile
    Created on : Oct 4, 2021, 5:31:20 AM
    Author     : selva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/includes/header.html" />

<h1>Change Password</h1>

<p>Provide your old and new passwords to update your password.</p>

<c:if test="${message != null}">
  <p><i>${message}</i></p>
</c:if>

<form action="profile" method="post">
  <input type="hidden" name="action" value="update_password" />
  <label class="pad_top">Old Password:</label>
  <input type="password" name="oldPassword" /><br />
  <label class="pad_top">New Password:</label>
  <input type="password" name="newPassword" /><br />
  <label class="pad_top">Confirm Password:</label>
  <input type="password" name="confirmPassword" /><br />
  <label>&nbsp;</label>
  <input type="submit" value="Update" class="margin_left" />
</form>

<h1>Logout</h1>

<p>You can safely logout from your account.</p>

<form action="profile" method="post">
  <input type="hidden" name="action" value="logout" />
  <input type="submit" value="Logout" class="margin_left" />
</form>

<h1>Delete Account</h1>

<p>Be careful!</p>

<form action="profile" method="post">
  <input type="hidden" name="action" value="delete_account" />
  <input type="submit" value="Delete" class="margin_left" />
</form>

<c:import url="/includes/footer.jsp" />
