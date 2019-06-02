<%@ page import="bean.Sitter" %>
<%@ page import="bean.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Sitter sitter = (Sitter) session.getAttribute("member");
%>
<jsp:include page="header.jsp"/>

<h3>All Active Jobs</h3>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Job Title</th>
        <th>Pay/hr(Rs.)</th>
        <th>Start Date</th>
        <th>Action</th>
        <th>Expected Pay</th>
    </tr>
    </thead>
    <tbody>

    <%
        List<Job> notAppliedJobs = (List<Job>) request.getAttribute("notAppliedJobs");

        for(Job notAppliedJob : notAppliedJobs){
            String title = notAppliedJob.getTitle();
            double payPerHour = notAppliedJob.getPayPerHour();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String startDate = dateFormat.format(notAppliedJob.getStartDateTime());
            int jobId = notAppliedJob.getId();

    %>

    <tr>
        <td><%= title%></td>
        <td><%=payPerHour%></td>
        <td><%=startDate%></td>
        <td>
        <form action="applyjob" method="post">
            <input type="text" value="<%=jobId%>" name="jobId" hidden>
            Expected Pay:<input type="text" name="expectedPay" required>
            <button type="submit" class="btn btn-primary btn-success btn-xs">Apply</button>
        </form>
        </td>

    </tr>

    <%
        }
    %>

    </tbody>
</table>

