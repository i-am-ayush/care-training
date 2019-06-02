<%@ page import="bean.Sitter" %><%--
  Created by IntelliJ IDEA.
  User: Amber
  Date: 5/30/2019
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Sitter sitter = (Sitter) session.getAttribute("member");
%>

<jsp:include page="header.jsp"/>


<h3>Welcome to Sitter Account</h3>

<h4>Hello <%=sitter.getFirstName()+" "+sitter.getLastName()%></h4>
<p>You have obtained a session with following details:</p>
<p>Phone:<%=" "+sitter.getPhoneNumber()%></p>
<p>Email:<%=" "+sitter.getEmail()%></p>
<p>Address:<%=" "+sitter.getAddress()%></p>
<p>Experience:<%=" "+sitter.getYearsOfExp()%></p>
<p>Expected Pay:<%=" "+sitter.getExpectedPay()%></p>

<a href="/editprofileform"><button class="btn btn-primary">Edit Profile</button></a>


</body>
</html>
