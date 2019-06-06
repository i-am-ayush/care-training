
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>

<h3>Edit Details</h3>

<form id="seekerform" action="editseekerprofile" method="POST">
    <label for="firstname">First name:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.Seeker.firstName}" name="firstname" id="firstname"></div>
    <label for="lastname">Last name:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.Seeker.lastName}" name="lastname" id="lastname"></div>
    <label for="phone">Phone number:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.Seeker.phoneNumber}" name="phone" id="phone"></div>
    <label for="email">Email:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.Seeker.email}" name="email" id="email"></div>
    <label for="address">Address:</label>
    <div class="form-group"><input class="form-control" type="text"  value="${requestScope.Seeker.address}" name="address" id="address"></div>
    <label for="spousename">Spouse name:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.Seeker.spouseName}" name="spousename" id="spousename"></div>
    <label for="children">No of Children:</label>
    <div class="form-group"><input class="form-control" type="text"value="${requestScope.Seeker.noOfChildren}"  name="children" id="children"></div>
    <label for="password">Password:</label>
    <div class="form-group"><input class="form-control" type="password" value="${requestScope.Seeker.password}" name="password" id="password"></div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>