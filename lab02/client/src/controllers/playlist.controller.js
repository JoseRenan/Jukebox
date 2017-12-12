(function () {
    'use strict';
    
    app.controller('playlistController', function (PlaylistService, NotificationService, artistas) {

        let getMusicas = () => {
            let artistasCadastrados = artistas;
            let musicas = [];
            for (let i in artistasCadastrados) {
                let albums = artistasCadastrados[i].albums;
                for (let j in albums) {
                    let musicasCopia = angular.copy(albums[j].musicas);
                    musicas = musicas.concat(musicasCopia);
                }
            }
            return musicas;
        }

        this.playlists = PlaylistService.playlists;
        this.musicas = getMusicas();
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
            PlaylistService.criaPlaylist(angular.copy(playlist), () => {
                NotificationService.success('Playlist criada com sucesso');
                this.musicas = getMusicas();
                this.playlist = {
                    musicas: []
                };
            }, (mensagem) => {
                NotificationService.error(`Erro ao salvar. ${mensagem}`);
            });
        }
    });
})();