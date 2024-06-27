<%-- 
    Document   : compra
    Created on : 13/06/2024, 20:32:23
    Author     : ariel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" href="./css/compra.css">
    </head>
    <body>
      <form class="payment-form">
        <h1>Forma de Pagamento</h1>
        
        <div class="pix-info">
            Caso o pagamento seja em Pix, copie e cole esse código: <strong>32574579dfduret752$%%</strong>
        </div>

        <label for="payment-method">Forma de pagamento:</label>
        <div class="radio-group">
            <label>
                <input type="radio" name="payment-method" value="pix" onclick="showCardInfo(this.value)" required>
                Pix
            </label>
            <label>
                <input type="radio" name="payment-method" value="debito" onclick="showCardInfo(this.value)">
                Débito
            </label>
            <label>
                <input type="radio" name="payment-method" value="credito" onclick="showCardInfo(this.value)">
                Crédito
            </label>
        </div>

          <div class="card-info">
            <label for="card-number">Número do cartão:</label>
            <input type="text" id="card-number" name="card-number" maxlength="19" placeholder="1234 5678 9012 3456">

            <label for="card-cvv">CVV:</label>
            <input type="text" id="card-cvv" name="card-cvv" maxlength="3">

            <label for="card-expiry">Validade (MM/AA):</label>
            <input type="text" id="card-expiry" name="card-expiry" placeholder="MM/AA">

            <label for="card-holder">Nome do titular:</label>
            <input type="text" id="card-holder" name="card-holder">
        </div>


        <button type="submit">Pagar</button>
    </form>
    </body>
    <script src="./js/compra.js"></script>
</html>
