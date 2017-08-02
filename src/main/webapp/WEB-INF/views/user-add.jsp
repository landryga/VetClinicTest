
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

Add user

<form:form method="POST" commandName = "user">
	
	<form:hidden path="id"/>
	
	<fieldset class="form-group">
		<form:label path="username">Name</form:label>
		<form:input path="username" type = "text" class="form-control" required = "required"/>
		<form:errors path="username" cssClass="text-warning"/>
	</fieldset>
	
	<fieldset class="form-group">
		<form:label path="email">Email</form:label>
		<form:input path="email" type = "text" class="form-control" required = "required"/>
		<form:errors path="email" cssClass="text-warning"/>
	</fieldset>
	
	<fieldset class="form-group">
		<form:label path="is_admin">Role</form:label>
		<form:select path="is_admin" type = "select" class="form-control" required = "required">
			<form:option value="false">User</form:option>
			<form:option value="true">Admin</form:option>
		</form:select>
		<form:errors path="is_admin" cssClass="text-warning"/>
	</fieldset>
	
	<input class = "btn btn-success" type = "submit" value="Submit"/>
</form:form>

</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<%@ include file="common/footer.jspf" %>
