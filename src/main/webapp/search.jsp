<%@ page import="bean.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<h3>Search Result</h3>

<table class="table table-hover">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Member Type</th>
    </tr>
    </thead>
    <tbody>




<c:forEach items="${requestScope.activeMembers}" var="j">
    <tr>
        <td>${j.firstName}</td>
        <td>${j.lastName}</td>
        <td>${j.email}</td>
        <td>${j.type}</td>
    </tr>

  </c:forEach>

    </tbody>
</table>
