<%@ page import="java.util.List" %>
<%@ page import="bean.Application" %>
<%@ page import="service.ApplicationService" %>
<%@ page import="bean.Member" %>
<%@ page import="service.MemberService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<h3>List of Job Applicants for</h3>

<%
    String title = String.valueOf(request.getAttribute("title"));

    List<Application> applications = (List<Application>) request.getAttribute("applications");
%>

<h3><%=title%>
</h3>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Sitter Name</th>
        <th>Application Status</th>
        <th>Expected Pay</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Application app : applications) {
            int memberid = app.getMemberId();
            Member member = MemberService.getMemberById(memberid);
            String sitterName = member.getFirstName() + " " + member.getLastName();
            String status = String.valueOf(app.getStatus());
            String expectedPay = String.valueOf(app.getExpectedPay());

    %>

    <tr>
        <td><%=sitterName%>
        </td>
        <td><%=status%>
        </td>
        <td><%=expectedPay%>
        </td>
    </tr>

    <%
        }
    %>

    </tbody>
</table>