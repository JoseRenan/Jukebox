(function () {
    'use strict';
    
    app.service('MusicaService', function (Musica) {

        this.listarMusicas = () => {
            return Musica.query();
        }

        this.listarMusicasPorArtista = (artistaId) => {
            return Musica.query({idArtista: artistaId});
        }

        this.listarMusicasPorNome = (nome) => {
            return Musica.query({nome: nome});
        }

        this.salvarMusicaEmArtista = (musica, nomeAlbum, artista, onSuccess, onError) => {
            musica.album = {nome: nomeAlbum, artista: artista};
            return Musica.post(musica)
                .then(musica => onSuccess())
                .catch(error => onError(error.message));
        }
    });
})();