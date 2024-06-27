<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./css/home.css">
        
        
    </head>
    <body>
        <%@include file="header.jsp" %>
       

        <main class="main-container">

            <div class="slide-container">
            <div class="slide">
                <img src="./imagens/ft1.png" >
            </div>
            <div class="slide">
                <img src="./imagens/ft2.png" >
            </div>
            <div class="slide">
                <img src="./imagens/cine.png" >
            </div>
            
            
            <a class="anterior" onclick="mudarSlide(-1)">&#10094;</a>
            <a class="proximo" onclick="mudarSlide(1)">&#10095;</a>
        </div>

        <section class="cards-produtos">
            <div class="row">
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/note_i7.png" alt="note i7">
                        <h4>Nitro 5</h4>
                        <p>Acer NITRO 5 Intel Core i7-13400H, 
                        16GB RAM, GeForce RTX3050, SSD 1T, 
                        15.6 Full HD, Linux, Preto - AN515-57-57XQ </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=1&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/core_i5.png" alt="note i7">
                        <h4>Dell g15</h4>
                        <p>Notebook Gamer Dell G15 Intel Core i5-13450HX, 16GB RAM, GeForce RTX 3050 6GB, SSD 500GB </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=1&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/ideapad_i5.png" alt="note i7">
                        <h4>IdeaPad 3i</h4>
                        <p>Notebook Gamer Lenovo Gaming 3i Intel Core i5-11300H, 8GB RAM, GeForce RTYX4050, SSD 256GB </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=1&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/ideapad_i5.png" alt="note i7">
                        <h4>IdeaPad 3i</h4>
                        <p>Notebook Gamer Lenovo Gaming 3i Intel Core i5-11300H, 8GB RAM, GeForce RTYX4050, SSD 256GB</p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=1&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/samsung.png" alt="note i7">
                        <h4>Samsung A05</h4>
                        <p>Celular Samsung Galaxy A05 128GB, Preto Quadriband - a155m/ds - a055mzksztoB </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=4&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/galaxy.png" alt="note i7">
                        <h4>Samsung galaxy A14</h4>
                        <p>Smartphone Samsung Galaxy A14, 4G, 128GB, 4GB RAM, Octa Core, Câmera Tripla de 50MP, Tela de 6.6 </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=4&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/motorola.png" alt="note i7">
                        <h4>Moto G54</h4>
                        <p>Smartphone Motorola Moto G54 5G, 256GB, 8GB RAM, Câmera 50MP, Selfie 16MP, Tela 6.5 </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=4&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/iphone.png" alt="note i7">
                        <h4>Iphone 15 Pro Max</h4>
                        <p>iPhone 15 Pro Max Apple 256GB, Câmera Tripla 48MP, Tela 6.7", Branco Titânio </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=4&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="img-promo">
                    <a href="http://localhost:8080/aula03/buscar-produtos?cat=4&busca=">
                        <img class="promo-arraia" src="./imagens/Arraia.png" alt="Arraia">
                    </a>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/monitorAOC.png" alt="note i7">
                        <h4>Monitor AOC</h4>
                        <p>Monitor Gamer AOC 27", 165Hz, Full HD, 1ms, DisplayPort, HDMI e VGA </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=2&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/ultrawide.png" alt="note i7">
                        <h4>Monitor ultrawide</h4>
                        <p>Monitor Gamer Curvo LG UltraGear LG 34", UltraWide, 160Hz, WQHD, 1ms, DisplayPort e HDMI </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=2&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/T350.png" alt="note i7">
                        <h4>Monitor samsung T350</h4>
                        <p>Monitor Gamer Samsung T350, 24" FHD, Tela Plana, 75Hz, 5Ms, HDMI </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=2&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card-1">
                        <img src="./imagens/curvo.png" alt="note i7">
                        <h4>Monitor curvo</h4>
                        <p>Monitor Concórdia Gamer, Curvo, 23.8 Polegadas, 100hz, Led, Full Hd </p>
                        <a href="http://localhost:8080/aula03/buscar-produtos?cat=2&busca="> Conhecer</a>
                    </div>
                </div>
                <div class="img-promo">
                    <a href="http://localhost:8080/aula03/buscar-produtos?cat=3&busca=">
                        <img class="promo-arraia" src="./imagens/perifericos1.png" alt="perifericos">
                    </a>
                </div>
            </div>
        </div>

        </section>

        </main>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <%@ include file="footer.jsp" %>
        <script src="./js/slides.js"></script>
    </body>
    
</html>
