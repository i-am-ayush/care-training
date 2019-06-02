<%@ page import="bean.Seeker" %><%--
  Created by IntelliJ IDEA.
  User: Amber
  Date: 5/30/2019
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Seeker seeker = (Seeker) session.getAttribute("member");
%>
<jsp:include page="header.jsp"/>


<h3>Welcome to Seeker Account</h3>

<h4>Hello <%=seeker.getFirstName()+" "+seeker.getLastName()%></h4>

<p>Phone:<%=" "+seeker.getPhoneNumber()%></p>
<p>Email:<%=" "+seeker.getEmail()%></p>
<p>Address:<%=" "+seeker.getAddress()%></p>
<p>Spouse Name:<%=" "+seeker.getSpouseName()%></p>
<p>No of Children:<%=" "+seeker.getNoOfChildren()%></p>


<a href="/editprofileform"><button class="btn btn-primary">Edit Profile</button></a>


</body>
</html>