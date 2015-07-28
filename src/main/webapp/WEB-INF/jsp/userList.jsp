<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Registered Users</title>
	</head>
	<body>
		<div align="center">
			<br><h3>List of Registered users....</h3>
			<table border="1">
				<tr>
					<td>Sl.</td>
					<td>Username</td>
					<td>Email</td>
					<td>Action..</td>
					<td>Action..</td>
				</tr> 
				<c:forEach var="user" items="${userList}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>
							<a href="<spring:url value="/listUsers/${user.id}.html" />">
								<c:out value="${user.name}" />
							</a>
						</td>
						<td>${user.email}</td>
						<td><a href="<c:url value='edit/${user.id}' />" >Edit</a></td>
						<td><a href="delete/${user.id}">delete</a></td>
					</tr>
				</c:forEach>             
			</table> 
		</div>
	</body>
</html>