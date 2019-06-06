<%@ page import="bean.Sitter" %>
<%@ page import="bean.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<jsp:include page="header.jsp"/>


<h3>Welcome to Sitter Account</h3>
<h4>Hello ${requestScope.sitter.firstName} ${requestScope.sitter.lastName}</h4>
<p>Phone:${requestScope.sitter.phoneNumber}</p>
<p>Email:${requestScope.sitter.email}</p>
<p>Address:${requestScope.sitter.address}</p>
<p>Experience:${requestScope.sitter.yearsOfExp}</p>

<a href="/editprofileform"><button class="btn btn-primary">Edit Profile</button></a>


</body>
</html>
