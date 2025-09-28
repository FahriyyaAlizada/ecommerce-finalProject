function loadOnTable(){
    const token = localStorage.getItem('token');

    fetch(`http://localhost:8040/card/getCard`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(async response => {
        let data = await response.json();
        console.log(data);

        let tableContent = '';
        let total = 0;

        data.forEach(card => {
            total += card.subTotal;
            tableContent += `
            <br>
                <tr>
                    <td>
                        <div style="display:flex; align-items:center; gap:10px;">
                            <img src="${card.product.image}" style="width:80px; height:70px;object-fit:cover;"/ >
                            ${card.product.brand}
                        </div>
                    </td>
                     <td>
                        <div style="display:flex; justify-content:center;">
                          ${card.product.price} $
                        </div>
                    </td>
                     <td>
                        <div style="display:flex; justify-content:center;">
                          <input type="number" min="1" value="${card.quantity}" class="quantity-input" data-cart-id="${card.id}" style="width: 50px;">
                        </div>
                    </td>
                     <td>
                        <div style="display:flex; justify-content:center;">
                          ${card.subTotal} $
                        </div>
                    </td>
                    <td>
                        <div>
                            <i class="fa-solid fa-trash delete-btn" data-id="${card.id}" style="color: rgb(221, 45, 74); cursor:pointer;"></i>
                        </div>
                    </td>
                </tr>
            `
        });
        
        document.getElementById('tbody').innerHTML = tableContent;
        document.querySelector('.subtotal p').textContent = `${total} $`;
        document.querySelector('.total p').textContent = `${total} $`;

        document.querySelectorAll('.quantity-input').forEach(input => {
            input.addEventListener('change', (e) => {
                let newQuantity = e.target.value;
                let cartId = e.target.getAttribute('data-cart-id');

                const cart = {
                    id: cartId,
                    quantity: newQuantity
                }

                fetch(`http://localhost:8040/card/update`, {
                    method: 'PUT',
                    headers: {
                        'Authorization': `Bearer ${token}`,
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(cart)
                })
                .then(msj => {
                    loadOnTable();
                })
            }) 
        })
    })
}

loadOnTable();

function deleteFromCart() {

    const token = localStorage.getItem('token');

    document.addEventListener('click', (e) => {
        if (e.target.classList.contains('delete-btn')) {
            let cardId = e.target.getAttribute('data-id');

            if (confirm('Are you sure to delete this product?')) {

                fetch(`http://localhost:8040/card/delete/${cardId}`, {
                    method: 'DELETE',
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                })
                    .then(resp => {
                        e.target.closest("tr").remove();
                        loadOnTable();
                    })
            }
        }
    })
}

deleteFromCart();

document.querySelector(".btn button").addEventListener('click', () => {

    const token = localStorage.getItem('token');

    fetch(`http://localhost:8040/card/getCard`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(async response => {
        let data = await response.json();
        
        let cartIds = data.map(cart => cart.id);
        console.log(cartIds);
       
        localStorage.setItem('cartIdss', JSON.stringify(cartIds));
        window.location.href = "checkout.html";
    })
})