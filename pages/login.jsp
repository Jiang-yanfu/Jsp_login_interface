<%! String type = "login"; %>
<%@ include file="../layouts/header.jsp" %>
<section>
	<% if (request.getAttribute("error_message") != null) {%>
	<p class="required" id="error">Sorry, authentication failed</p>
	<%} %>
	<form id = "form" method="post" action = "/jsp/AuthUser">
			<p>
			<label for = "name">Name: </label>
			<input id="name" name = "name" type = "text" autofocus autocomplete required placeholder="your name" />
			</p>
			<p>
			<label for="password">Password: </label>
			<input id = "password" name = "password" type = "password" required placeholder = "the length is at least 6 chars" pattern = "^[A-Za-z0-9]{6,}$" />
			</p>
			<br />
			<input type = "submit" id = "submit" name = "submit" value="login" />
		</form>
</section>
<%@ include file="../layouts/footer.jsp"%>