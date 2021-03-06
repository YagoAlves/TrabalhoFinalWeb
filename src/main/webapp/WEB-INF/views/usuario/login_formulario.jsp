<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
<title>Efetuar login</title>
</head>

<body>
	
	<h1 align="center"> Escolha o papel</h1>
	<div id="loginDiv" >
	<form class="form-horizontal" action="autenticarLogin" method="post" >	
		 	<select class="form-control" id="sel1" name="id" >
		   		<c:forEach var="papel" items="${papeis}">
					<option value="${papel.id}">${papel.papel}</option>
				</c:forEach>
			  </select>
		<div class="form-group" align="center">
			<label for="inputEmail3" class="col-sm-2 control-label">Login</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputEmail3"
					placeholder="Login" name="login">
			</div>
		</div>
		<div class="form-group" align="center">
			<label for="inputPassword3" class="col-sm-2 control-label">
				Senha </label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Senha" name="senha">
			</div>
		</div>

			<div class="form-group" align="center">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Logar</button>
				</div>
			</div>	
			
			<div class="form-group" align="center">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="/" class="btn btn-primary">Voltar ao inicio</a>
				</div>
			</div>	
				
	</form>
	</div>
</body>
</html>