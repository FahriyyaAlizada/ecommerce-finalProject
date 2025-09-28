const contactForm = document.querySelector('form');

contactForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const messagee = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('phone').value,
        message: document.getElementById('message').value
    }

    fetch('http://localhost:8040/contact', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body:JSON.stringify(messagee)
    })
    .then(async response => {
        if (response.ok) {
            alert('Message saved successfully');
            window.location.href = "contact.html";
            document.getElementById('name').value = '';
            document.getElementById('email').value = '';
            document.getElementById('phone').value = '';
            document.getElementById('message').value = '';
        }else{
            const data = await response.json();
            alert(data.message);
        }
    })
})
