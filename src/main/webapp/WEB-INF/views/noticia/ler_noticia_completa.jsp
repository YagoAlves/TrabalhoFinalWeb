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

<title> Noticia completa</title>

</head>

<body>
	
	<div id="noticiaCompleta"> 
		<h1>
			<img src="../../resources/imagens/noticias/${noticia.titulo}
			.png" class="img-thumbnail"> 
			${noticia.titulo} 
		</h1>
			<br> 
	</div>
		<h2> ${noticia.subtitulo} </h2>
			<br> 
		<h3> ${noticia.texto} </h3>
			<br> 
		<h3> Noticia feita por : ${noticia.usuario.nome} </h3>
		    <br>
	<div id="noticiaCompleta">
		<h4> Comentários de outro usuários </h4>
			<br> 
		<table class="table table-striped">
		<c:forEach var="comentario" items="${comentarios}">
			<tr>
				<c:if test="${comentario.ativo == true}">
				<td>${comentario.usuario.login}</td>
				<td>${comentario.texto}</td>
					<c:if test="${comentario.usuario.login == usuario_logado.login}">
						<td> <a  class="btn btn-danger" href="apagarComentario?
						id=${comentario.id}"> Apagar comentario </a> </td>
					</c:if>
				</c:if>
			</tr>
		</c:forEach>
		</table>
		
		<c:if test="${not empty usuario_logado}">
			<form action="inserirComentario?id_noticia=${noticia.id}&id_usuario=${usuario_logado.id}" method="post"> 
				Comentário:<input type="text" name="comentario" />
						   <input type="submit" class="btn btn-primary" value="Comentar">
			</form>
		</c:if>
	</div>
	
	
</body>
</html>