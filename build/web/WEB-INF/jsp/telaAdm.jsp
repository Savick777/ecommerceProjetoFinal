<%-- 
    Document   : telaAdm
    Created on : 26/06/2024, 00:51:59
    Author     : ariel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/adm.css">
    </head>
   <body>
    <header>
        <h1>Painel administrativo</h1>
        <nav>
            <a href="./home">Home</a>
        </nav>
    </header>
    <div class="container">
        <h2>Escolha uma opção abaixo</h2>
        <button onclick="location.href='./cadastrar'">Cadastrar Usuário</button>
        <button onclick="location.href='./cadastrarProduto'">Cadastrar Produto</button>
    </div>
</body>
</html>
