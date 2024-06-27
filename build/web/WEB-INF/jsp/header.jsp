<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" href="./css/header.css">

        
    </head>
    <body>
        
        <header class="container header-container">
            
            <div class="logo">

                <a href="./home">
                   <img src="./imagens/logo_ok.png" alt="logo"> </div>
               </a> 
            </button>

            <div class="menu">
                <nav>
                    <ul>
                        <li>
                            <c:forEach items="${categorias}" var="categoria">
                                <a href="./buscar-produtos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a>
                            </c:forEach>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="perfil">
                <button class="cart">
                    <a href="#"><i class="fa-solid fa-cart-shopping" id="btn-abrir-carrinho"></i></a>
                </button>
                <button class="user">
                    <a href="./login"><i class="fa-solid fa-user"></i></a>
                </button>
            </div>
            <div class="bar-container">
                <form class="pesquisar" action="buscar-produtos" method="get">
                    <input name="busca" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn-buscar" type="submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </form>
            </div>
        </header>
        </header>
        <div id="carrinho">
            <div id="background-carrinho">
            </div>
            <div id="carrinho-container">
                <div class="carrinho-header">
                    <i id="fechar-carrinho" class="fa-solid fa-xmark"></i>
                </div>
                <div id="carrinho-main"></div>
                <div class="carrinho-footer">
                    <a class="btn btn-finalizar" href="./compra">FINALIZAR COMPRA</a>
                </div>

            </div>
        </div>
        
    </body>
       
    <script src="./js/carrinho.js"></script>
</html>
