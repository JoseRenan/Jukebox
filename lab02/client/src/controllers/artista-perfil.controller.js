(function () {
    'use strict';
    
    app.controller('artistaPerfilController', function (artista, OuvirService) {

        this.artista = artista;
        console.log(artista);

        let getMusicas = () => {
            let musicas = [];
            let albums = this.artista.albums;
            for (let i in albums) {
                musicas = musicas.concat(albums[i].musicas);
            }
            return musicas;
        };

        this.musicas = getMusicas();

        this.numeroDeMusicas = () => {
            let numeroMusicas = 0;
            for (let i in this.artista.albums) {
                numeroMusicas += this.artista.albums[i].musicas.length;
            }
            return numeroMusicas;
        }

        this.ouvir = (musica) => {
            OuvirService.ouvir(this.artista, musica);
        }

    });
})();