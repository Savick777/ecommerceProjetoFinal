let indiceSlide = 1;
mostrarSlides(indiceSlide);

function mudarSlide(n) {
    mostrarSlides(indiceSlide += n);
}

function mostrarSlides(n) {
    let i;
    let slides = document.getElementsByClassName("slide");
    if (n > slides.length) {indiceSlide = 1}    
    if (n < 1) {indiceSlide = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";  
    }
    slides[indiceSlide-1].style.display = "block";  
}
