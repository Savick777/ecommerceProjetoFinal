<%-- 
    Document   : cadastrar
    Created on : 20/04/2024, 15:42:15
    Author     : ariel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/cadastro.css">
    </head>
    <body>
        <div class="cadastro-container">
        <h2>Cadastro de Usuário</h2>
        <form action="cadastrar" method="post">
            <input type="text" name="nome" placeholder="Nome" required>
            <input type="text" name="usuario" placeholder="usuario" required>
            <input type="password" name="senha" placeholder="senha" required>
            <input type="text" name="cpf" placeholder="cpf" required>
            <input type="text" name="telefone" placeholder="telefone" required>
            <input type="date" name="data_nascimento" placeholder="data_nascimento" required>

            <button type="submit">Cadastrar</button>
        </form>
    </div>
    </body>
</html>
