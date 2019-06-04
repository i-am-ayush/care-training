<%@ page import="bean.Seeker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>

<h3>Edit Job Details</h3>

<form action="editjobdetails" method="POST">

    <label for="jobtitle">Job Title</label>
    <div class="form-group"><input type="text" class="form-control" value="${requestScope.updateJob.title}" name="title" id="title" /></div>

    <label for="startdate">Start Date(dd/mm/yyyy)</label>
    <div class="form-group"><input type="text" class="form-control" value="${requestScope.updateJob.startDateTime}" name="startDateTime" id="startDateTime" /></div>

    <label for="enddate">End Date(dd/mm/yyyy)</label>
    <div class="form-group"><input type="text" class="form-control" value="${requestScope.updateJob.endDateTime}" name="endDateTime" id="endDateTime" /></div>

    <label for="jobtitle">Pay per hour</label>
    <div class="form-group"><input type="text" class="form-control" value="${requestScope.updateJob.payPerHour}" name="payPerHour"  /></div>

    <div class="form-group"><button class="btn btn-primary" type="submit">Update</button></div>

</form>
