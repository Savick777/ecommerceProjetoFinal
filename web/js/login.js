const form = document.getElementById("formulario");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const usuario = document.getElementById("usuario").value;
    const senha = document.getElementById("senha").value;

    if(usuario.trim() === "" || senha.trim() === "") {
        alert("Usuário e/ou Senha não preenchidos!")
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "/login", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    window.location.href = "./home";
                } else {
                    alert("Usuário ou senha incorretos.");
                }
            }
        };
        
        const data = "usuario=" + encodeURIComponent(usuario) + "&senha=" + encodeURIComponent(senha);
        xhr.send(data);
    }
});
