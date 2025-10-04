function getOrder() {

    let subTotal = document.getElementById('subtotal');
    subTotal.textContent = " $"+localStorage.getItem("totalAmount");

    let totall = document.getElementById('totalAmount');
    totall.textContent = " $" + (Number(localStorage.getItem("totalAmount")) + 15);

    let brands = JSON.parse(localStorage.getItem("brands")) || [];
    let itemsElement = document.getElementById("items");
    itemsElement.innerHTML = "<strong>Purchased items:</strong> ";
    brands.forEach((brand, index) => {
        let span = document.createElement("span");
        span.textContent = brand;
        if (index < brands.length - 1) {
            span.textContent += ", ";
        }

        itemsElement.appendChild(span);
    });

}

getOrder()