<%@ page import="java.util.Date" %>
<%@ page import="bean.Seeker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>


<form action="postnewjob" method="POST">

    <label for="title">Job Title</label>
    <div class="form-group"><input type="text" class="form-control" name="title" id="title" /></div>

    <label for="startDate">Start Date(dd/mm/yyyy)</label>
    <div class="form-group"><input type="text" class="form-control" name="startDate" id="startDate" /></div>

    <label for="endDate">End Date(dd/mm/yyyy)</label>
    <div class="form-group"><input type="text" class="form-control" name="endDate" id="endDate" /></div>

    <label for="payPerHour">Pay per hour</label>
    <div class="form-group"><input type="text" class="form-control" name="payPerHour"  /></div>

    <button class="btn btn-primary" type="submit">Post</button>

</form>
