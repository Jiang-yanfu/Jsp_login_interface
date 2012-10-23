<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<% if(request.getAttribute("model") != null && request.getAttribute("model").equals("yes")){%>
<link href = "../jsp/styles/styles.css" rel="stylesheet" />
<script src ="../jsp/script/script.js"></script>
<script src="../jsp/script/ajax.js" type="text/javascript"></script>
<% }else{%>
<link href = "../styles/styles.css" rel="stylesheet" />
<script src ="../script/script.js"></script>
<%} %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%if (session.getAttribute("name") != null){ %>
	<title>Welcome, <%= session.getAttribute("name") %></title>
<%} %>
</head>
<body>
<div id= "wrapper">
<header><h1>Welcome to the JSP login interface</h1></header>
<nav>

</nav>