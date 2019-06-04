<%@ page import="java.util.List" %>
<%@ page import="bean.Application" %>
<%@ page import="service.ApplicationService" %>
<%@ page import="bean.Member" %>
<%@ page import="dto.ApplicantDto" %>
<%@ page import="service.MemberService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>

<h3>List of Job Applicants for</h3>

<h3>${requestScope.title}
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
   <c:forEach items="${requestScope.applicantList}" var="j">

    <tr>
        <td>${j.name}
        </td>
        <td>${j.status}
        </td>
        <td>${j.expectedPay}
        </td>
    </tr>
  </c:forEach>

    </tbody>
</table>