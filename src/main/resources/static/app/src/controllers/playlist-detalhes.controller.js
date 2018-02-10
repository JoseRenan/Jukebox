(function () {
    'use strict';
    
    app.controller('playlistDetalhesController', function (playlist, musicas, PlaylistService, NotificationService) {
        
        this.playlist = playlist;
        this.musicas = musicas;

        this.removerMusica = (musica) => {
            PlaylistService.removeMusicaPlaylist(musica, this.playlist, (playlist) => {
                this.playlist = playlist;
                NotificationService.success(`Removida com sucesso`);
            }, (mensagem) => {
                NotificationService.error(`Erro ao remover. ${mensagem}`);
            });
        }

        this.adicionarMusica = (musica) => {
            PlaylistService.adicionaMusicaPlaylist(musica, this.playlist, (playlist) => {
                this.playlist = playlist;
                NotificationService.success(`Adicionada com sucesso`);
            }, (mensagem) => {
                NotificationService.error(`Erro ao adicionar. ${mensagem}`);
            });
        }
    });
})();