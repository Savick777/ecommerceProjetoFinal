document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("cadastrarProduto");

    form.addEventListener("submit", function(e) {
        e.preventDefault();
        const nome = document.getElementById("nome").value.trim();

        if(nome === "" || nome === null) {
            alert("Preencha o campo Nome");
        } else {
            alert("Enviado!");
        }
    });

});