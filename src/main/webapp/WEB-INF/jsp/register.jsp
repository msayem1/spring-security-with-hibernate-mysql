<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
	</head>
	<body>
		<div align="center">        	
			<h2>User Registration</h2><br>
			<c:url var="addAction" value="/add-edit" ></c:url>
			<form:form method="post" action="${addAction}" commandName="user">
				<c:if test="${param.success eq true}">
					<div class="alert alert-success">
						<h4>Registration Successful!</h4>
					</div>
				</c:if>
				<c:if test="${param.update eq true}">
					<div class="alert alert-success">
						<h4>Update Successful!</h4>
					</div>
				</c:if>
				<table>
					<tr>
						<td><label for="id">Id:</label></td>
						<td><form:input readonly="true" path="id" /></td>
					</tr><tr>
						<td><label for="name">Username:</label></td>
						<td><form:input path="name" /></td>
					</tr><tr>
						<td><label for="password">Password:</label></td>
						<td><form:input path="password" /></td>
					</tr><tr>
						<td><label for="email">Email:</label></td>
						<td><form:input path="email" /></td>
					</tr><tr>
						<td colspan="2">			            
							<c:if test="${!empty user.name}">
								<input type="submit" value="<spring:message text="Edit Person"/>" />
							</c:if>
							<c:if test="${empty user.name}">
								<input type="submit" value="<spring:message text="Save"/>" />
							</c:if>
						</td>
					</tr>
				</table> 
			</form:form> 
		</div>     
	</body>
</html>