(function () {
    'use strict';
    
    app.controller('musicaController', function (ArtistaService, NotificationService, artistas) {
        
        this.artistas = artistas;
        console.log(artistas);

        this.salvarMusica = (musica, album, artista) => {
            ArtistaService.salvarMusicaEmArtista(musica, album, artista, () => {
                delete this.musica;
                delete this.album;
                delete this.artista;
                NotificationService.success('Música criada com sucesso');
            }, (mensagem) => {
                NotificationService.error(`Erro ao salvar. ${mensagem}`);
            });
        }
    });
})();