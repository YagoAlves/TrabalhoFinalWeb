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
<title>Inserir Noticia</title>
</head>
<body>
	  <h2 align="center">Inserir Noticia </h2>
	  <div id="inserirNoticia"> 
		  <form action="inserirNoticia?id_usuario=${usuario_logado.id}" method="post" enctype="multipart/form-data">
			  <select class="form-control" id="sel1" name="id_secao" >
					<c:forEach var="secao" items = "${secoes}">
							<option value="${secao.id}">${secao.titulo}</option>
					</c:forEach>
			  </select>
			  <div class="form-group">
			    <label> Titulo </label>
			    <input type="text" class="form-control" placeholder="Titulo da noticia" name="titulo">
			  </div>
			  <div class="form-group">
			    <label> Subtitulo </label>
			    <input type="text" class="form-control" placeholder="Subtitulo da noticia" name="subtitulo">
			  </div>
			  <div class="form-group">
			    <label> Texto </label>
			    <textarea name="texto" rows="10" cols="40"
			     class="form-control" placeholder="Texto da noticia" >
			    </textarea>
			  </div>
			  <div class="form-group">
			    <label> Imagem da noticia</label>
			    <input type="file" name="imagem">
			  </div>
			  <button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
</body>
</html>