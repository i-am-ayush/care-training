<%@ page import="bean.Sitter" %>
<%@ page import="bean.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>

<h3>All Active Jobs</h3>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Job Title</th>
        <th>Pay/hr(Rs.)</th>
        <th>Start Date</th>
        <th>Action</th>

    </tr>
    </thead>
    <tbody>

        <c:forEach items="${requestScope.notAppliedJobs}" var="j">

    <tr>
        <td>${j.title}</td>
        <td>${j.payPerHour}</td>
        <td>${j.startDateTime}</td>
        <td>
        <form action="applyjob" method="post">
            <input type="text" value="${j.id}" name="jobId" hidden>
            Expected Pay:<input type="text" name="expectedPay" required>
            <button type="submit" class="btn btn-primary btn-success btn-xs">Apply</button>
        </form>
        </td>

    </tr>

</c:forEach>

    </tbody>
</table>

