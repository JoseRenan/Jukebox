(function () {
    'use strict';
    
    app.controller('artistaPerfilController', function (musicas, artista, OuvirService, ArtistaService) {

        this.artista = artista;
        this.musicas = musicas;

        this.numeroDeMusicas = () => {
            return musicas.length;
        }

        this.ouvir = (musica) => {
            OuvirService.ouvir(this.artista, musica);
        }

        this.onRating = (artista) => {
            ArtistaService.atualizarArtista(this.artista.artistaId, this.artista)
                .then(artista => (this.artista = artista));
        }

    });
})();