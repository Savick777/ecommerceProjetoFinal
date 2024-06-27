<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./css/produtos.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <main class="main-container">
            
       <div class="produto-container">
    
    <div class="row">
        <c:forEach var="produto" items="${produtos}">
            <div class="col-md-4 mb-3">
                <div class="card card-custom">
                    <img class="card-img-top" src="${produto.imagem}" alt="${produto.nome}">
                    <div class="card-body">
                        <h5 class="card-title">${produto.nome}</h5>
                        <p class="card-text categoria-text">Categoria: ${produto.categoria}</p>
                        <p class="card-text">Valor: R$ ${produto.valor}</p>
                        <p class="card-text">Descrição: ${produto.descricao}</p>
                    </div>
                    <button class="btn btn-comprar" data-idproduto="${produto.idProduto}">COMPRAR</button>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
        </main>
       
       <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <%@ include file="footer.jsp" %>
    </body>
</html>


