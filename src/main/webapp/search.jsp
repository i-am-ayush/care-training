<%@ page import="bean.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<h3>Search Result</h3>

<table class="table table-hover">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Member Type</th>
    </tr>
    </thead>
    <tbody>

    <%
        List<Member> activeMembers = (List<Member>) request.getAttribute("activeMembers");

        for(Member member : activeMembers){
            String firstName = member.getFirstName();
            String lastName = member.getLastName();
            String email = member.getEmail();
            String memberType = String.valueOf(member.getType());
    %>

    <tr>
        <td><%=firstName%></td>
        <td><%=lastName%></td>
        <td><%=email%></td>
        <td><%=memberType%></td>
    </tr>

    <%
        }
    %>

    </tbody>
</table>
