<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EBook:User</title>
</head>
<body>
	<h1 class="text-center">User:Home</h1>
	<c:if test="${not empty userObj}">
	<h1>Name:${userObj.name}</h1>
	<h1>Email:${userObj.email}</h1>
	</c:if>
</body>
</html>