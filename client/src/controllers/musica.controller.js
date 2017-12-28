(function () {
    'use strict';
    
    app.controller('musicaController', function (MusicaService, NotificationService, artistas) {
        
        this.artistas = artistas;

        this.salvarMusica = (musica, album, artista) => {
            MusicaService.salvarMusicaEmArtista(musica, album, artista, () => {
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