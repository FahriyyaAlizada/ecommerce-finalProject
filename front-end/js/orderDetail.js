function getOrder(){
    let token = localStorage.getItem('token');

    let urlParams = new URLSearchParams(window.location.search);
    let cartId = urlParams.get('cartId');

    fetch(`http://localhost:8040/orders/getById/${cartId}`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
.then(async response => {
            let object = await response.json();
            console.log(object);

            let name = document.getElementById('name');
            name.textContent = object.firstName + " " + object.lastName;

            let addresss = document.getElementById('address');
            addresss.textContent = object.address;

            let phonee = document.getElementById('phone');
            phonee.textContent = object.phone;

            let subTotal = document.getElementById('subtotal');
            subTotal.textContent = localStorage.getItem("totalAmount") + " $";

            let totall = document.getElementById('totalAmount');
            totall.textContent = localStorage.getItem("totalAmount") + 15 + " $";

        })
}

getOrder()