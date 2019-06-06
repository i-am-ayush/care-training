<%@ page import="bean.Seeker" %>
<%@ page import="bean.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>

<body>
<h3>Welcome to Seeker Account</h3>
<h4>Hello ${requestScope.seeker.firstName} ${requestScope.seeker.lastName}</h4>

<p>Phone:${requestScope.seeker.phoneNumber}</p>
<p>Email:${requestScope.seeker.email}</p>
<p>Address:${requestScope.seeker.address}</p>
<p>Spouse Name:${requestScope.seeker.spouseName}</p>
<p>No of Children:${requestScope.seeker.noOfChildren}</p>


<a href="/editprofileform"><button class="btn btn-primary">Edit Profile</button></a>


</body>
</html>