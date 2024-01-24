function calculer() {
    const a = document.getElementById('a').value;
    const b = document.getElementById('b').value;
    const c = document.getElementById('c').value;

    // Vérifier si les champs sont remplis
    if (a === '' || b === '' || c === '') {
        document.getElementById('resultat').innerText = "Veuillez entrer les valeurs de a, b et c.";
        return;
    }

    fetch('/calculer', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ a, b, c })
    })
    .then(response => {
        if (!response.ok) {
            throw response;
        }
        return response.json();
    })
    .then(data => {
        if (data.error) {
            document.getElementById('resultat').innerText = `Erreur : ${data.error}`;
        } else if (data.solutions && data.solutions.length > 0) {
            const resultatText = data.solutions.length > 1 ? 
                                 `Les solutions sont : ${data.solutions.join(' et ')}` :
                                 `La solution est : ${data.solutions[0]}`;
            document.getElementById('resultat').innerText = resultatText;
        } else {
            document.getElementById('resultat').innerText = "Pas de solutions réelles.";
        }
    })
    .catch(error => {
        error.json().then(errorMessage => {
            document.getElementById('resultat').innerText = `${errorMessage.error}`;
        }).catch(() => {
            document.getElementById('resultat').innerText = "Erreur lors du calcul.";
        });
    });
}
