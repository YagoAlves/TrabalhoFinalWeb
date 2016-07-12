<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir editor</title>
</head>
<body>
	
	<h2 align="center">Inserir editor </h2>
	<div id="inserirEditor">
		<form action="inserirUsuarioEditor" method="post" enctype="multipart/form-data" >
		  <div class="form-group">
		  	<div class="form-group">
		    	<label> Nome </label>
		    	<input type="text" class="form-control" placeholder="Nome completo" name="nome">
		  	</div>
		    <label> Email </label>
		    <input type="text" class="form-control" placeholder="Email" name="email">
		  </div>
		  <div class="form-group">
		    <label> Login </label>
		    <input type="text" class="form-control" placeholder="Login" name="login">
		  </div>
		  <div class="form-group">
		    <label> Senha </label>
		    <input type="password" class="form-control" name="senha">
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