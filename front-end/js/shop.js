function showProducts(){

    const token = localStorage.getItem('token');

    fetch('http://localhost:8040/products/all', {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(async response => {
        if (response.ok) {
            const data = await response.json();
            console.log(data);
            
            data.products.forEach(element => {

                let cardsDiv = document.querySelector('.cards');

                let cardDiv = document.createElement('div');
                cardDiv.classList.add('card');
                cardDiv.setAttribute('data-id',element.id);
                
                let imgDiv = document.createElement('div');

                let image = document.createElement('img');
                image.src = element.image;

                let h5 = document.createElement('h5');
                h5.textContent = element.brand;

                let p = document.createElement('p');
                p.textContent = element.price + " $";

                let rate = document.createElement('h3');
                rate.classList.add('stars');
                rate.textContent = "★".repeat(Math.round(element.rating));

                let addToCardBtn = document.createElement('button');
                addToCardBtn.textContent = 'Add to card';
                addToCardBtn.setAttribute('data-id', element.id);

                addToCardBtn.addEventListener('click', (e) => {
                    e.stopPropagation();
                    let productId = addToCardBtn.getAttribute('data-id');
                    console.log(productId);

                    addToCart(productId);
                    
                })
                
                imgDiv.append(image);
                cardDiv.append(imgDiv);
                cardDiv.append(h5);
                cardDiv.append(p);
                cardDiv.append(rate);
                cardDiv.append(addToCardBtn);

                cardsDiv.append(cardDiv);
            });
        }
    })
}

showProducts();


function searchProduct(){
    const token = localStorage.getItem('token');

    const query = document.getElementById('searchInput').value;

    fetch(`http://localhost:8040/products/search?query=${query}`, {
        method: 'GET',
        headers:{
            'Authorization': `Bearer ${token}`
        }
    })
    .then(async response => {
        let data = await response.json();
        console.log(data);

        let cards = document.querySelector('.cards');
        cards.innerHTML = '';
        
        data.forEach(element => {

                let cardsDiv = document.querySelector('.cards');

                let cardDiv = document.createElement('div');
                cardDiv.classList.add('card');
                cardDiv.setAttribute('data-id',element.id);
                
                let imgDiv = document.createElement('div');

                let image = document.createElement('img');
                image.src = element.image;

                let h5 = document.createElement('h5');
                h5.textContent = element.brand;

                let p = document.createElement('p');
                p.textContent = element.price + " $";

                let rate = document.createElement('h3');
                rate.classList.add('stars');
                rate.textContent = "★".repeat(Math.round(element.rating));

                let addToCardBtn = document.createElement('button');
                addToCardBtn.textContent = 'Add to card';

                imgDiv.append(image);
                cardDiv.append(imgDiv);
                cardDiv.append(h5);
                cardDiv.append(p);
                cardDiv.append(rate);
                cardDiv.append(addToCardBtn);

                cardsDiv.append(cardDiv);
            });
    })
}

function sortProducts(){

    const token = localStorage.getItem('token');

    let sortSelect = document.getElementById('sortSelect');

    sortSelect.addEventListener('change', () => {
        let sortValue = document.getElementById('sortSelect').value;

        fetch(`http://localhost:8040/products/sort?sort=${sortValue}`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
        .then(async response => {
            let data = await response.json();
            console.log(data);

            let cards = document.querySelector('.cards');
            cards.innerHTML = '';

            data.forEach(element => {

                let cardsDiv = document.querySelector('.cards');

                let cardDiv = document.createElement('div');
                cardDiv.classList.add('card');
                cardDiv.setAttribute('data-id',element.id);
                
                let imgDiv = document.createElement('div');

                let image = document.createElement('img');
                image.src = element.image;

                let h5 = document.createElement('h5');
                h5.textContent = element.brand;

                let p = document.createElement('p');
                p.textContent = element.price + " $";

                let rate = document.createElement('h3');
                rate.classList.add('stars');
                rate.textContent = "★".repeat(Math.round(element.rating));

                let addToCardBtn = document.createElement('button');
                addToCardBtn.textContent = 'Add to card';

                imgDiv.append(image);
                cardDiv.append(imgDiv);
                cardDiv.append(h5);
                cardDiv.append(p);
                cardDiv.append(rate);
                cardDiv.append(addToCardBtn);

                cardsDiv.append(cardDiv);
            });
                        
        })
    })
}

sortProducts()

document.addEventListener('click', (e) => {
    if (e.target.closest('.card')) {
        let productId = e.target.closest('.card').getAttribute('data-id');
        console.log(productId);
        
        window.location.href = `productDetail.html?id=${productId}`;
    }
})


function addToCart(productId){

    const token = localStorage.getItem('token');

    const cart = {
        productId: productId
    }

    fetch(`http://localhost:8040/card/add`, {
        method: 'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cart)
    })
    .then(async response => {
        let message = await response.text();
        alert(message);
    })
}
