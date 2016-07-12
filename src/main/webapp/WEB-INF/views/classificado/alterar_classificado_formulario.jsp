<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Classificado</title>
</head>
<body>
	<h2>Alterar Classificado</h2>
	<form action="alterarClassificado" method="post">
		<input type="hidden" name="id" value="${classificado.id}">
		Titulo: <input type="text" name="titulo" value="${classificado.titulo}" /> <br />
		Descricao: <input type="text" name="descricao" value="${classificado.descricao}" /> <br />
		Texto : <input type="text" name="texto" value="${classificado.texto}" /> <br />
		preço : <input type="text" name="preco" value="${classificado.preco}" /> <br />
		telefone: <input type="text" name="telefone" value="${classificado.telefone}" /> <br />
		Melhor oferta : <input type="text" name="melhor_oferta" value="${classificado.melhor_oferta}" /> 
		
		<input type="submit" value="ALTERAR" /> 
	</form>
</body>
</html>