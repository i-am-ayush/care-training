<%@ page import="bean.Sitter" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.SitterProfileHome" %>
<%@ page import="service.SitterService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>


<jsp:include page="header.jsp"/>


<h3>List of Applied Jobs</h3>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Job Title</th>
        <th>Expected Pay(Lpa)</th>
        <th>Pay/hr(Rs.)</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
 <c:forEach items="${requestScope.appliedJobList}" var="j">

    <tr>
        <td>${j.title}
        </td>
        <td>${j.expectedPay}
        </td>
        <td>${j.payPerHour}
        </td>
        <td>${j.status}
        </td>
        <td>
            <form method="POST" action="deletesitterapplication" style="display:inline">
                <input type="text" value="${j.applicationId}" name="id" hidden>
                <button class="btn btn-xs btn-danger" type="button" data-toggle="modal" data-target="#confirmDelete"
                        data-title="Delete Application"
                        data-message="Are you sure you want to delete this application ?" <%=disabled%>>
                    <i class="glyphicon glyphicon-trash"></i> Delete Application
                </button>
            </form>
        </td>
    </tr>
</c:forEach>
    </tbody>

</table>


</body>
</html>