<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Usuario</title>
</head>
<body>
	<h2>Inserir Usuario </h2>
	<form action="inserirUsuario" method="post">
		
		Nome: <input type="text" name="nome" />
		Email: <input type="text" name="email" />
		Login: <input type="text" name="login" /> 
		Papel: <input type="text" name="papel" />
			
		<input type="submit" value="SALVAR" /> 
	</form>
</body>
</html>