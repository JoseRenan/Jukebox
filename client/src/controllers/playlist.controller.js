(function () {
    'use strict';
    
    app.controller('playlistController', function (PlaylistService, NotificationService, musicas, playlists, $state) {

        this.playlists = playlists;
        this.musicas = angular.copy(musicas);
        this.playlist = {
            musicas: []
        };

        this.adicionarOuRemoverMusicaPlaylist = (musica, playlist) => {
            if (!musica.adicionada) {
                playlist.musicas.push(musica);
            } else {
                let index = playlist.musicas.indexOf(musica);
                if (index > -1) {
                    playlist.musicas.splice(index, 1);
                }
            }
            musica.adicionada = !musica.adicionada;
        }

        this.salvarPlaylist = (playlist) => {
            PlaylistService.criaPlaylist(angular.copy(playlist), (playlist) => {
                NotificationService.success('Playlist criada com sucesso');
                $state.reload();
            }, (mensagem) => {
                NotificationService.error(`Erro ao salvar. ${mensagem}`);
            });
        }
    });
})();