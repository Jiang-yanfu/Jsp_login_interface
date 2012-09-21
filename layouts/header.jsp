<% if(type.equals("login")){
			if(session.getAttribute("name") == null && session.getAttribute("admin_name") == null)
			{
				Cookie[] cookies = request.getCookies();
				for(Cookie each : cookies)
				{
					System.out.println("cookie: " + each.getName() + " : " + each.getValue());
					if(each.getName().equals("name"))
					{
						session.setAttribute("name", each.getValue());
						response.sendRedirect("http://localhost:8080/jsp/pages/LoggedIn.jsp");
					}
				}
			}
			else
			{
				response.sendRedirect("http://localhost:8080/jsp/pages/LoggedIn.jsp");
			}
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%
if (type.equals("index") || type.equals("error")) {
%>
<link href="styles/styles.css" rel="stylesheet" />
<%
			} else if (type.equals("login")
			&& request.getAttribute("error_message") == null
			|| type.equals("register")
			&& request.getAttribute("error_message") == null || type.equals("admin_login")
			&& request.getAttribute("error_message") == null) {
%>
<link href="../styles/styles.css" rel="stylesheet" />
<script src="../script/script.js"></script>
<%
			} else if (type.equals("login")
			&& request.getAttribute("error_message") != null
			|| type.equals("register")
			&& request.getAttribute("error_message") != null || type.equals("admin_login")
			&& request.getAttribute("error_message") != null) {
%>
<link href="styles/styles.css" rel="stylesheet" />
<script src="script/script.js"></script>
<%
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
if (type.equals("index")) {
%>
<title>Welcome</title>
<%
} else if (type.equals("register")) {
%>
<title>Register</title>
<%
} else if (type.equals("error")) {
%>
<title>Error</title>
<%
} else if (type.equals("login")) {
%>
<title>Login</title>
<%
}
%>
</head>
<body>
<div id="wrapper"><header>
<h1>Welcome to the JSP login interface</h1>
</header> <nav>
<ul>
	<%
				if (type.equals("index") || type.equals("error")
				|| request.getAttribute("error_message") != null) {
	%>
	<li><a href="pages/register.jsp">Register</a></li>
	<li><a href="pages/login.jsp">Login</a></li>
	<li><a href="pages/admin_login.jsp">Admin</a></li>
	<%
	} else {
	%>
	<li><a href="register.jsp">Register</a></li>
	<li><a href="login.jsp">Login</a></li>
	<li><a href="admin_login.jsp">Admin</a></li>
	<%
	}
	%>


</ul>
</nav>