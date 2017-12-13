(function () {
    'use strict';
    
    app.controller('artistaPerfilController', function (musicas, artista, OuvirService) {

        this.artista = artista;
        this.musicas = musicas;

        this.numeroDeMusicas = () => {
            return musicas.length;
        }

        this.ouvir = (musica) => {
            OuvirService.ouvir(this.artista, musica);
        }

    });
})();