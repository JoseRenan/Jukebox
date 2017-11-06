(function () {
    'use strict';
    
    app.controller('musicaController', function (ArtistaService, NotificationService) {
        
        this.artistas = ArtistaService.artistas;

        this.salvarMusica = (musica, album, artista) => {
            ArtistaService.salvarMusicaEmArtista(musica, album, artista, () => {
                delete this.musica;
                delete this.album;
                delete this.artista;
                NotificationService.success('Música criada com sucesso');
            }, () => {
                NotificationService.error('Aconteceu um erro');
            });
        }
    });
})();