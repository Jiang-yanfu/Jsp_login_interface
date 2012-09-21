<%! String type = "register"; %>
<%@ include file="../layouts/header.jsp" %>
<section>
		<h4>Please enter the information below to register for the application</h4>
		<% if (request.getAttribute("error_message") == null) {%>
		<p class="required" id="error">* is required field</p>
		<%}else{ %>
		<p class="required" id="error"><%= request.getAttribute("error_message") %></p>
		<%} %>
		<form id = "form" method="post" action = "/jsp/CreateUser">
			<p>
			<label for = "name">*Name: </label>
			<input id="name" name = "name" type = "text" autofocus autocomplete required placeholder="your name" />
			</p>
			<p>
			<label for="password1">*Password: </label>
			<input id = "password1" name = "password" type = "password" required placeholder = "the length is at least 6 chars" pattern = "^[A-Za-z0-9]{6,}$" />
			</p>
			<p>
			<label for="password2">*Password: </label>
			<input id = "password2" type = "password" required placeholder = "reenter your password" pattern = "^[A-Za-z0-9]{6,}$"/>
			</p>
			<p>
			<label for="email">Email: </label>
			<input id = "email" name = "email" type = "email" placeholder = "email address" pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.(com|org|net|edu|gov|mil|biz|info|mobi|name|aero|asia|jobs|museum)$"/>
			<p><br />
			<input type = "submit" id = "submit" name = "submit" value = "register" />
		</form>
</section>
<%@ include file="../layouts/footer.jsp"%>