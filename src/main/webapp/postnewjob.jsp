<%@ page import="java.util.Date" %>
<%@ page import="bean.Seeker" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<%
    Seeker seeker = (Seeker) session.getAttribute("member");
%>

<form action="postnewjob" method="POST">

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

    <button class="btn btn-primary" type="submit">Post</button>

</form>
