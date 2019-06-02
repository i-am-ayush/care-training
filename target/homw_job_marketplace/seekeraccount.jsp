<%@ page import="com.mysql.cj.Session" %>
<%@ page import="bean.Seeker" %>
<%@ page import="bean.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="service.SeekerService" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Amber
  Date: 5/29/2019
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Seeker seeker = (Seeker) session.getAttribute("member");
%>
<jsp:include page="header.jsp"/>

<h3>List of Posted Jobs</h3>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Job Title</th>
        <th>Status</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th colspan="3">Actions</th>
    </tr>
    </thead>
    <tbody>

    <%
        List<Job> jobsPosted = SeekerService.allJobPostedBySeeker(seeker.getMemberId());
        String title = "", status = "", startDate = "", endDate = "";
        int jobId = 0;
        for (Job jobPosted : jobsPosted) {
            title = jobPosted.getTitle();
            status = String.valueOf(jobPosted.getStatus());
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            startDate = dateFormat.format(jobPosted.getStartDateTime());
            endDate = dateFormat.format(jobPosted.getEndDateTime());
            jobId = jobPosted.getId();
    %>
    <tr>
        <td><%=title%>
        </td>
        <td><%=status%>
        </td>
        <td><%=startDate%>
        </td>
        <td><%=endDate%>
        </td>
        <td>
            <form method="POST" action="editjobdetails.jsp" style="display:inline">
                <input type="text" value="<%=jobId%>" name="id" hidden>
                <button class="btn btn-xs btn-success" type="submit">
                    <i class="glyphicon glyphicon-edit"></i> Edit Job
                </button>
            </form>
        </td>
        <td>
            <form method="POST" action="applicantlist" style="display:inline">
                <input type="text" value="<%=jobId%>" name="id" hidden>
                <button class="btn btn-xs btn-primary" type="submit">
                    <i class="glyphicon glyphicon-list"></i> List Applications
                </button>
            </form>
        </td>
        <td>
            <form method="POST" action="closejob" style="display:inline">
                <input type="text" value="<%=jobId%>" name="id" hidden>
                <button class="btn btn-xs btn-danger" type="button" data-toggle="modal" data-target="#confirmDelete"
                        data-title="Close Job" data-message="Are you sure you want to close this job?">
                    <i class="glyphicon glyphicon-trash"></i> Close Job
                </button>
            </form>
        </td>

    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
