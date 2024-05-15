

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/cadastroProdutos.css">
    </head>
    <body>
      <h1>Cadastro de Produto</h1>
    <form action="home" method="post" enctype="multipart/form-data">
        <label for="categoria">Categoria:</label>
        <input type="text" id="categoria" name="categoria" required>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <label for="valor">Valor:</label>
        <input type="number" id="valor" name="valor" step="0.01" required>
        <label for="descricao">Descrição:</label>
        <textarea id="descricao" name="descricao" rows="4" required></textarea>
        <label for="imagem">Imagem:</label>
        <input type="file" id="imagem" name="imagem" accept="image/*" required>
        <input type="submit" value="Cadastrar Produto">
    </form>

    </body>
</html>
