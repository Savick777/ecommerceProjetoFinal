document.addEventListener("DOMContentLoaded", function() {
    const abrirCarrinho = document.getElementById("btn-abrir-carrinho");
    const fecharCarrinho = document.getElementById("fechar-carrinho");
    const background = document.getElementById("background-carrinho");
    const carrinho = document.getElementById("carrinho");

    abrirCarrinho.addEventListener("click", function() {
        carrinho.classList.add("aberto");
    });
    
    

    fecharCarrinho.addEventListener("click", fechar);
    background.addEventListener("click", fechar);

    function fechar() {
        carrinho.classList.remove("aberto");
    }
    
    
    function carregarCarrinho() {
        const request = new XMLHttpRequest();
        request.open("GET", "carrinho", true);
        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
                const data = JSON.parse(request.responseText);
                
                console.log(data); 

                const carrinho = document.getElementById("carrinho-main");

                carrinho.innerHTML = " ";

                data.forEach(produto => {
                    const divP = document.createElement("div");
                    divP.classList.add("produto");

                    const divImg = document.createElement("div");
                    divImg.classList.add("container-img");
                    divImg.innerHTML = '<img src ="'+produto.imagem+'" > ';

                    const divInfo = document.createElement("div");
                    divP.classList.add("container-info");
                    divInfo.innerHTML = '<h3>'+produto.nome+'</h3><h4 class="preco">R$ '+produto.valor.toFixed(2)+'</h4>';

                    divP.appendChild(divImg);
                    divP.appendChild(divInfo);
                    carrinho.appendChild(divP);

                });

            }
        };
        request.send();
    }
    
    carregarCarrinho();

 
    function adicionarItemAoCarrinho(idProduto) {
        const request = new XMLHttpRequest();
        request.open("POST", "carrinho", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
               
                carregarCarrinho();
            }
        };
        request.send("id=" + idProduto);
    }

   
    const btns = document.getElementsByClassName("btn-comprar");
    for(let i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function() {
            const idProduto = this.getAttribute("data-idproduto");
            adicionarItemAoCarrinho(idProduto);
        });
    }
});
