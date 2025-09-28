document.getElementById('log-out').addEventListener('click', () => {
    localStorage.removeItem('token');
})

window.onload = () => {
    const username = localStorage.getItem("username");

    if (username) {
        // Show username
        document.getElementById("usernameDisplay").textContent = username;

        // Show/hide buttons
        document.getElementById("log-in").style.display = "none";
        document.getElementById("log-out").style.display = "inline-block";
        document.getElementById("cardIcon").style.display = "inline-block";
        document.getElementById("userIcon").style.display = "inline-block";
    } else {
        document.getElementById("usernameDisplay").textContent = "";
        document.getElementById("log-in").style.display = "inline-block";
        document.getElementById("log-out").style.display = "none";
        document.getElementById("cardIcon").style.display = "none";
        document.getElementById("userIcon").style.display = "none";
        document.getElementById("question").style.marginLeft = "45px";
    }

    document.getElementById("log-out").addEventListener("click", () => {
        localStorage.removeItem("username");
        window.location.reload();
    });
};
