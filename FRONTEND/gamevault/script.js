




function rodar() {
    let Iusername  = document.querySelector(".username").value;
    let Ipassword  = document.querySelector(".password").value;

    let login = {
    username: Iusername,
    password: Ipassword,
    }
    fetch('http://localhost:8080/login', {
    method: 'POST',
    body: JSON.stringify(login),
    headers: {
        'Content-Type':'application/json'
    }
})
.then(response => {
    
    console.log(response.status);
    if (response.status == 200) {
        window.location.href = "./pag2.html"
    }
    return response.text()
}).then(info => {
    console.log(info)
    localStorage.setItem('user', JSON.stringify({"token":info}));
})
    

    
}

/*
function rodar() {
    
}

*/

