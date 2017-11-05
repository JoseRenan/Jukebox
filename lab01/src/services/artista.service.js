(function () {
    'use strict';
    
    app.service('ArtistaService', function () {
        
        this.artistas = [];

        this.salvar = (artista, onSuccess, onError) => {
            let nomeIgual = (elem) => { return elem.nome === artista.nome }
            if (!this.artistas.find(nomeIgual)) {
                this.artistas.push(artista);
                onSuccess();
            } else {
                onError();
            }
        }
    });
})();