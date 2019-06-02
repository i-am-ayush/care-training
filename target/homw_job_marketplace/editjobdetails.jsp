<%@ page import="bean.Seeker" %><%--
  Created by IntelliJ IDEA.
  User: Amber
  Date: 5/31/2019
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<%
    Seeker seeker = (Seeker) session.getAttribute("member");
    int jobId = Integer.parseInt(request.getParameter("id"));
%>
<h3>Edit Job Details</h3>

<form action="editjobdetails" method="POST">

    <label for="jobId">Job ID</label>
    <div class="form-group"><input type="text" class="form-control" value="<%=jobId%>" name="jobId" id="jobId" readonly/></div>

    <label for="jobtitle">Job Title</label>
    <div class="form-group"><input type="text" class="form-control" name="jobtitle" id="jobtitle" /></div>

    <label for="postedby">Posted by(Member ID)</label>
    <div class="form-group"><input type="text" class="form-control" name="postedby" value="<%= seeker.getMemberId()%>" id="postedby" readonly /></div>

    <label for="startdate">Start Date(dd/mm/yyyy)</label>
    <div class="form-group"><input type="text" class="form-control" name="startdate" id="startdate" /></div>

    <label for="enddate">End Date(dd/mm/yyyy)</label>
    <div class="form-group"><input type="text" class="form-control" name="enddate" id="enddate" /></div>

    <label for="jobtitle">Pay per hour</label>
    <div class="form-group"><input type="text" class="form-control" name="payperhour"  /></div>

    <div class="form-group"><button class="btn btn-primary" type="submit">Update</button></div>

</form>
