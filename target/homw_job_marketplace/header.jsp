<%@ page import="bean.Member" %>
<%@ page import="bean.Seeker" %>
<%@ page import="static java.lang.System.exit" %><%--
  Created by IntelliJ IDEA.
  User: Amber
  Date: 5/30/2019
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Member member = (Member) session.getAttribute("member");
    int memberid = member.getId();
    String profilePage, page2, page2url, homepage;
    String firstName = member.getFirstName();
    String lastName = member.getLastName();
    String membertype = String.valueOf(member.getType());
    if(membertype.equals("SEEKER")){
        profilePage = "seekerprofile.jsp";
        page2 = "Post New Job";
        page2url = "postnewjob.jsp";
        homepage = "seekeraccount.jsp";
    }
    else {
        profilePage = "sitterprofile.jsp";
        page2 = "Apply New Job";
        page2url = "applynewjob";
        homepage = "sitteraccount.jsp";
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title><%= firstName%></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>


<body>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<%= homepage%>">Home Job Marketplace</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="<%= homepage%>">Home</a></li>
            <li><a href="<%=profilePage%>">Profile</a></li>
            <li><a href="<%=page2url%>"><%= page2%></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <form class="navbar-form navbar-left" action="/search" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" name="email" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Search</button>
                </form>
            </li>
            <li>
                <form class="navbar-form navbar-left" method="POST" action="closeaccount">
                    <input type="text" value="<%=memberid%>" name="id" hidden>
                    <button class="btn btn-danger" type="button" data-toggle="modal" data-target="#confirmDelete" data-title="Close Account" data-message="Are you sure you want to close your account permanently ?">
                        <i class="glyphicon glyphicon-ban-circle"></i> Close Account
                    </button>
                </form>
            </li>
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>



<jsp:include page="confirm.jsp"/>




</body>
</html>

