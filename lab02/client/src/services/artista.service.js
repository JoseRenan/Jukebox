(function () {
    'use strict';
    
    app.service('ArtistaService', function (Artista) {

        this.listarArtistas = () => {
            return Artista.query();
        }

        this.buscaArtistaPorNome = (nome) => {
            return Artista.query(nome);
        }

        this.recuperarArtista = (artistaId) => {
            return Artista.get(artistaId);
        }

        this.salvarArtista = (artista, onSuccess, onError) => {
            Artista.post(artista)
                .then(artista => onSuccess())
                .catch(erro => onError(erro.message));
        }
    });
})();