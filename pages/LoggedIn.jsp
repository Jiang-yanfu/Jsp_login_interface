<%
	System.out.println(session.getAttribute("name"));
	if(session.getAttribute("name") == null){
	response.sendRedirect("http://localhost:8080/jsp/pages/login.jsp");
}
%>
<%! String type = "loggedIn"; %>
<%@ include file="../layouts/header_login.jsp" %>
<section>
	<p id="loggedIn">You have logged in as <%= session.getAttribute("name") %></p>
	<% if(request.getAttribute("model") != null && request.getAttribute("model").equals("yes")){%>
	<a href="../jsp/Logout">Logout</a>
	<% }else {%>
	<a href="../Logout">Logout</a>
	<%} %>
</section>
<%@ include file="../layouts/footer.jsp"%>