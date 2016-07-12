
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Usuario </title>
</head>
<body>
	<h2>Listar Usuario</h2>
	<table border="1">
	<c:forEach var="usuario" items="${usuarios}">
		<tr>
			<td>${usuario.email}</td>
			<td>${usuario.login}</td>
			<td>${usuario.nome}</td>
			<td><a href="apagarUsuario?id=${usuario.id}">APAGAR</a></td>
			<td><a href="alterarUsuarioFormulario?id=${usuario.id}">ALTERAR</a></td>
		</tr>
	</c:forEach>
	</table>	
</body>
</html>