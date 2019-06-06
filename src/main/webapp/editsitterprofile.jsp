
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>

<h3>Edit Details</h3>

<form id="sitterform" action="editsitterprofile" method="POST">
   <label for="firstname">First name:</label>
       <div class="form-group"><input class="form-control" type="text" value="${requestScope.Sitter.firstName}" name="firstname" id="firstname"></div>
       <label for="lastname">Last name:</label>
       <div class="form-group"><input class="form-control" type="text" value="${requestScope.Sitter.lastName}" name="lastname" id="lastname"></div>
       <label for="phone">Phone number:</label>
       <div class="form-group"><input class="form-control" type="text" value="${requestScope.Sitter.phoneNumber}" name="phone" id="phone"></div>
       <label for="email">Email:</label>
       <div class="form-group"><input class="form-control" type="text" value="${requestScope.Sitter.email}" name="email" id="email"></div>
       <label for="address">Address:</label>
       <div class="form-group"><input class="form-control" type="text"  value="${requestScope.Sitter.address}" name="address" id="address"></div>
    <label for="experience">Experience:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.Sitter.yearsOfExp}" name="experience" id="experience"></div>
    <label for="expectedpay">Expected Pay:</label>
    <div class="form-group"><input class="form-control" type="text" value="${requestScope.Sitter.expectedPay}" name="expectedpay" id="expectedpay"></div>
    <label for="password">Password:</label>
    <div class="form-group"><input class="form-control" type="password" value="${requestScope.Sitter.password}" name="password" id="password"></div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
