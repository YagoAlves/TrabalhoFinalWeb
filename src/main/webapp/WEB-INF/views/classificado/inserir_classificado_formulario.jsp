<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Seção</title>
</head>
<body>
	<h2>Inserir Seção </h2>
	<form action="inserirClassificado" method="post">
		
		Titulo: <input type="text" name="titulo" /> <br />
		Descrição: <input type="text" name="descricao" /> <br />
		Texto: <input type="text" name="texto" /> <br />
		Preço: <input type="text" name="preco" /> <br />
		Telefone: <input type="text" name="telefone" /> <br />
		Melhor oferta: <input type="text" name="melhor_oferta" /> <br />
		Id usuario : <input type="text" name="id_usuario" /> <br />
				
		<input type="submit" value="SALVAR" /> 
	</form>
</body>
</html>