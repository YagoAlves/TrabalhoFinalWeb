<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Seção</title>
</head>
<body>
	<h2>Listar Seção</h2>
	<table border="1">
	<c:forEach var="classificado" items="${classificados}">
		<tr>
			<td>${classificado.titulo}</td>
			<td>${classificado.descricao}</td>
			<td><a href="apagarSecao?id=${secao.id}">APAGAR</a></td>
			<td><a href="alterarSecaoFormulario?id=${secao.id}">ALTERAR</a></td>
		</tr>
	</c:forEach>
	</table>	
</body>
</html>