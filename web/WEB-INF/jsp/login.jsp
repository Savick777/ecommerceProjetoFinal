
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tela de Login</title>
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="/login" id="formulario" method="post">
            <input type="text" id="usuario" name="usuario" placeholder="Usuário" required>
            <input type="password" id="senha" name="senha" placeholder="Senha" required>
            <button type="submit">Entrar</button>
        </form>
        <p>Não tem uma conta? <a href="./cadastrar">Cadastre-se</a></p>
    </div>
</body>
<script src="./js/login.js"></script>
</html>