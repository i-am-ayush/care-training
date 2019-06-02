<%@ page import="bean.Sitter" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="service.SitterService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Sitter sitter = (Sitter) session.getAttribute("member");
%>

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

    <%
        List<Map<String, Object>> list = SitterService.allAppliedJobBySitter(sitter.getMemberId());

        for (Map<String, Object> appliedjobs : list) {
            String title = "", payperhour = "", expectedpay = "", status = "", disabled = "";
            int appid = 0;
            for (Map.Entry<String, Object> applicationdetails : appliedjobs.entrySet()) {
                if (applicationdetails.getKey().equals("title"))
                    title = String.valueOf(applicationdetails.getValue());
                else if (applicationdetails.getKey().equals("payPerHour"))
                    payperhour = String.valueOf(applicationdetails.getValue());
                else if (applicationdetails.getKey().equals("expectedPay"))
                    expectedpay = String.valueOf(applicationdetails.getValue());
                else if (applicationdetails.getKey().equals("status")) {
                    status = String.valueOf(applicationdetails.getValue());
                    if (status.equals("INACTIVE")) {
                        disabled = "disabled";
                    }
                } else if (applicationdetails.getKey().equals("applicationId"))
                    appid = (int) applicationdetails.getValue();
            }
    %>
    <tr>
        <td><%=title%>
        </td>
        <td><%=expectedpay%>
        </td>
        <td><%=payperhour%>
        </td>
        <td><%=status%>
        </td>
        <td>
            <form method="POST" action="deletesitterapplication" style="display:inline">
                <input type="text" value="<%=appid%>" name="id" hidden>
                <button class="btn btn-xs btn-danger" type="button" data-toggle="modal" data-target="#confirmDelete"
                        data-title="Delete Application"
                        data-message="Are you sure you want to delete this application ?" <%=disabled%>>
                    <i class="glyphicon glyphicon-trash"></i> Delete Application
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