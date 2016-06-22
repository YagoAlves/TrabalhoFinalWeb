<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Noticia</title>
</head>
<body>
	<h2>Inserir Noticia </h2>
	<form action="inserirNoticia" method="post">
		
		Subtitulo: <input type="text" name="subtitulo" /> <br>
		Titulo: <input type="text" name="titulo" /> <br>
		Texto: <input type="text" name="texto" /> <br>
		id da seção : <input type="text" name="id_secao" />
			
		<input type="submit" value="SALVAR" /> 
	</form>
</body>
</html>