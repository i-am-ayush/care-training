
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>

<h3>Edit Details</h3>

<form id="seekerform" action="editseekerprofile" method="POST">
    <label for="firstname">First name:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.seeker.firstName}" name="firstName" id="firstName"></div>
    <label for="lastname">Last name:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.seeker.lastName}" name="lastName" id="lastName"></div>
    <label for="phone">Phone number:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.seeker.phoneNumber}" name="phone" id="phone"></div>
    <label for="email">Email:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.seeker.email}" name="email" id="email"></div>
    <label for="address">Address:</label>
    <div class="form-group"><input class="form-control" type="text"  value="${requestScope.seeker.address}" name="address" id="address"></div>
    <label for="spousename">Spouse name:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.seeker.spouseName}" name="spouseName" id="spouseName"></div>
    <label for="children">No of Children:</label>
    <div class="form-group"><input class="form-control" type="text"value="${requestScope.seeker.noOfChildren}"  name="noOfChildren" id="noOfChildren"></div>
    <label for="password">Password:</label>
    <div class="form-group"><input class="form-control" type="password" value="${requestScope.seeker.password}" name="password" id="password"></div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>