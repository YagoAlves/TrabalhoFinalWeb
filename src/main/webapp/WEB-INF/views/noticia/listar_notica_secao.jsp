<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

	<link rel="stylesheet" type="text/css" href="../../resources/css/estilo.css">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head> 
	
	<body>
		<h1>Noticias da seção : ${noticia.secao.titulo} </h1>

		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading"> Noticias </div>
			<!-- Table -->
			<table class="table">
				<c:forEach var="noticia" items="${noticias}">
					<tr>
						<td>${noticia.titulo}</td>
						<td>${noticia.subtitulo}</td>
						<td><a href="lerNoticiaCompleta?id=${noticia.id}"> Ler
								noticia completa </a></td>
					</tr>
				</c:forEach>
			</table>
		</div>	
	</body>

</html>