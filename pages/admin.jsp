<%@page import="java.util.*" %>
<%
	System.out.println(session.getAttribute("name"));
	if(session.getAttribute("admin_name") == null){
	response.sendRedirect("http://localhost:8080/jsp/pages/admin_login.jsp");
}
%>
<%! String type = "loggedIn"; %>
<%@ include file="../layouts/header_login.jsp" %>
<section>
	<p id="loggedIn">Admin have logged in as <%= session.getAttribute("name") %></p>
	<%
		ArrayList<String> users = (ArrayList<String>)request.getAttribute("users");
	%>
	<table>
		<tr><th>Name</th><th>Option</th></tr>
		<% for(String user : users){ %>
			<tr><td><% out.print(user); %></td><td><a href = "#">delete?</a></td></tr>
		<%} %>
	</table>
	<% if(request.getAttribute("model") != null && request.getAttribute("model").equals("yes")){%>
	<a href="../jsp/Logout">Logout</a>
	<% }else {%>
	<a href="../Logout">Logout</a>
	<%} %>
</section>
<%@ include file="../layouts/footer.jsp"%>