<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:getAsString name="title" /></title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	</head>
	<body>
		<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
		<tilesx:useAttribute name="current" />
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> You are here -> ${current}</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="${current == 'home' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'listUsers' ? 'active' : ''}"><a href='<spring:url value="/listUsers" />'>List Users</a></li>
						</security:authorize>
						<security:authorize access="! isAuthenticated()">
							<li class="${current == 'register' ? 'active' : ''}"><a href='<spring:url value="/register" />'>Register</a></li>
							<li class="${current == 'login' ? 'active' : ''}"><a href='<spring:url value="/login" />'>Login</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class="${current == 'account' ? 'active' : ''}"><a href='<spring:url value="/account" />'>My Account</a></li>
							<li> <a href='<spring:url value="/logout" />'>Logout</a></li>
						</security:authorize>
					</ul>
				</div>
			</div>
		</nav>
		<br><br>
		<div class="container-fluid">
			<div class="row">
				<br><br>
				<tiles:insertAttribute name="body" />
				<br><br>
			</div>
		</div>
	</body>
</html>