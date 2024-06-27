function showCardInfo(paymentMethod) {
    var cardInfo = document.querySelector('.card-info');
    if (paymentMethod === 'credito' || paymentMethod === 'debito') {
        cardInfo.style.display = 'block';
    } else {
        cardInfo.style.display = 'none';
    }
}

function formatCardNumber(event) {
    var input = event.target;
    var value = input.value.replace(/\D/g, '');
    var formattedValue = value.replace(/(\d{4})(?=\d)/g, '$1 ');
    input.value = formattedValue;
}

function validateExpiryDate(value) {
    return /^(0[1-9]|1[0-2])\/\d{2}$/.test(value);
}


function validateForm(event) {
    var paymentMethod = document.querySelector('input[name="payment-method"]:checked').value;
    if (paymentMethod === 'credito' || paymentMethod === 'debito') {
        var cardNumber = document.getElementById('card-number').value.replace(/\s/g, '');
        var cardCVV = document.getElementById('card-cvv').value;
        var cardExpiry = document.getElementById('card-expiry').value;
        var cardHolder = document.getElementById('card-holder').value;

        if (cardNumber.length === 16 && cardCVV.length === 3 && cardExpiry && cardHolder) {
            alert("PARABÉNS PELA COMPRA");
        } else {
            alert("PREENCHIMENTO OBRIGATÓRIO");
            event.preventDefault();
        }
    } else {
        alert("PARABÉNS PELA COMPRA");
    }
}

document.addEventListener('DOMContentLoaded', function() {
    var form = document.querySelector('.payment-form');
    form.addEventListener('submit', validateForm);
    var cardNumberInput = document.getElementById('card-number');
    cardNumberInput.addEventListener('input', formatCardNumber);
});