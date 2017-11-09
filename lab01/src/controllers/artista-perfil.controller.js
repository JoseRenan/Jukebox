(function () {
    'use strict';
    
    app.controller('artistaPerfilController', function (artista) {

        this.artista = artista;

        this.numeroDeMusicas = () => {
            let numeroMusicas = 0;
            for (let i in this.artista.albums) {
                numeroMusicas += this.artista.albums[i].musicas.length;
            }
            return numeroMusicas;
        }

    });
})();