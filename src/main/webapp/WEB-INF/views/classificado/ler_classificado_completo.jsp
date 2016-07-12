<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> Classificado completo</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" type="text/css" href="../../resources/css/estilo.css">
		
	</head>

		<body>
			<div id="noticiaCompleta"> 
				
				<h1> ${classificado.titulo}</h1>
				<h3> ${classificado.texto} </h3>
				<h3>Preço : ${classificado.preco}</h3>
				<h3>Telefone de contato : ${classificado.telefone}</h3>
				<h3>${classificado.data_oferta}</h3>
				<h3>Melhor oferta : ${classificado.melhor_oferta} <br>
					Feita pelo usuario : ${classificado.usuario.nome}  </h3>
				<c:if test="${not empty usuario_logado}">
					<form action="inserirOferta?id_classificado=${classificado.id}&
					id_usuario=${usuario_logado.id}" method="post">
						Digite o preço <input type="text" name="melhor_oferta"/> 
						<input type="submit" class="btn btn-primary" value="Inserir oferta">
					</form>			
				</c:if>
			</div>
		</body>
	
</html>