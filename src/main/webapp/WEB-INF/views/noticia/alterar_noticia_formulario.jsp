<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar noticia</title>
</head>
<body>
	<h2>Alterar noticia</h2>
	
	<form action="alterarNoticia" method="post">
		<input type="hidden" name="id" value="${noticia.id}">
		Texto : <input type="hidden" name="texto" value="${noticia.texto}">
		Subtitulo :<input type="hidden" name="subtitulo" value="${noticia.subtitulo}">
		Titulo: <input type="text" name="titulo" value="${comentario.titulo}" /> 
		<input type="submit" value="ALTERAR" /> 
	</form>
</body>
</html>