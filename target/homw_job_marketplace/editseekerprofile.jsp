<%--
  Created by IntelliJ IDEA.
  User: Amber
  Date: 6/2/2019
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<h3>Edit Details</h3>

<form id="seekerform" action="editseekerprofile" method="POST">
    <label for="membertype">Member Type:</label>
    <div class="form-group"><input type="text" value="SEEKER" name="membertype" id="membertype" readonly></div>
    <label for="firstname">First name:</label>
    <div class="form-group"><input class="form-control" type="text" name="firstname" id="firstname"></div>
    <label for="lastname">Last name:</label>
    <div class="form-group"><input class="form-control" type="text" name="lastname" id="lastname"></div>
    <label for="phone">Phone number:</label>
    <div class="form-group"><input class="form-control" type="text" name="phone" id="phone"></div>
    <label for="email">Email:</label>
    <div class="form-group"><input class="form-control" type="text" name="email" id="email"></div>
    <label for="address">Address:</label>
    <div class="form-group"><input class="form-control" type="text" name="address" id="address"></div>
    <label for="spousename">Spouse name:</label>
    <div class="form-group"><input class="form-control" type="text" name="spousename" id="spousename"></div>
    <label for="children">No of Children:</label>
    <div class="form-group"><input class="form-control" type="text" name="children" id="children"></div>
    <label for="password">Password:</label>
    <div class="form-group"><input class="form-control" type="password" name="password" id="password"></div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>