<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Papel</title>
</head>
<body>
	<h2>Listar Papel</h2>
	<table border="1">
	<c:forEach var="papel" items="${papeis}">
		<tr>
			<td>${papeis.texto}</td>
			<td><a href="apagarPapel?id=${papeis.id}">APAGAR</a></td>
			<td><a href="alterarPapelFormulario?id=${papeis.id}">ALTERAR</a></td>
		</tr>
	</c:forEach>
	</table>	
</body>
</html>