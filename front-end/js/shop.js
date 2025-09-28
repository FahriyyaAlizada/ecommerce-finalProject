let allProducts = [];

function createProductCard(element, cardsDiv) {
    let cardDiv = document.createElement('div');
    cardDiv.classList.add('card');
    cardDiv.setAttribute('data-id', element.id);

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
    });

    imgDiv.append(image);
    cardDiv.append(imgDiv, h5, p, rate, addToCardBtn);
    cardsDiv.append(cardDiv);
}

function showProducts() {
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
            allProducts = data.products;
            const cardsDiv = document.querySelector('.cards');
            cardsDiv.innerHTML = '';
            data.products.forEach(element => {
                createProductCard(element, cardsDiv);
            });
        }
    })
    .catch(error => console.error('Error fetching products:', error));
}

function searchProduct() {
    const token = localStorage.getItem('token');
    const query = document.getElementById('searchInput').value;

    fetch(`http://localhost:8040/products/search?query=${query}`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}`
        }
    })
    .then(async response => {
        const data = await response.json();
        console.log(data);
        const cardsDiv = document.querySelector('.cards');
        cardsDiv.innerHTML = '';
        data.forEach(element => {
            createProductCard(element, cardsDiv);
        });
    })
    .catch(error => console.error('Error searching products:', error));
}

function sortProducts() {
    const token = localStorage.getItem('token');
    const sortSelect = document.getElementById('sortSelect');

    sortSelect.addEventListener('change', () => {
        const sortValue = sortSelect.value;
        fetch(`http://localhost:8040/products/sort?sort=${sortValue}`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
        .then(async response => {
            const data = await response.json();
            console.log(data);
            const cardsDiv = document.querySelector('.cards');
            cardsDiv.innerHTML = '';
            data.forEach(element => {
                createProductCard(element, cardsDiv);
            });
        })
        .catch(error => console.error('Error sorting products:', error));
    });
}

function filterByCategory() {
    const categoryLinks = document.querySelectorAll('.sidebar ul li a');

    categoryLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            const category = link.textContent.toLowerCase();
            const cardsDiv = document.querySelector('.cards');
            cardsDiv.innerHTML = '';

            const filteredProducts = allProducts.filter(product => 
                product.category.toLowerCase() === category);

            filteredProducts.forEach(element => {
                createProductCard(element, cardsDiv);
            });
        });
    });
}

function filterByRating() {
    const ratingFilters = document.querySelectorAll('.rate-filter p');

    ratingFilters.forEach(rating => {
        rating.addEventListener('click', () => {
            const ratingValue = rating.textContent.split('★').length - 1;
            const cardsDiv = document.querySelector('.cards');
            cardsDiv.innerHTML = '';

            const filteredProducts = allProducts.filter(product => 
                Math.round(product.rating) === ratingValue);

            filteredProducts.forEach(element => {
                createProductCard(element, cardsDiv);
            });
        });
    });
}

showProducts();
sortProducts();
filterByCategory();
filterByRating();

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
        window.location.href = "card.html";
    })
}
