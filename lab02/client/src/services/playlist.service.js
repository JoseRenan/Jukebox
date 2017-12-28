(function () {
    'use strict';
    
    app.service('PlaylistService', function (Playlist) {

        this.listarPlaylists = () => {
            return Playlist.query();
        };

        this.buscaPlaylistPorId = (idPlaylist) => {
            return Playlist.get(idPlaylist);
        }

        this.adicionaMusicaPlaylist = (musica, playlist, onSuccess, onError) => {
            return Playlist.postMusica(playlist.playlistId, musica)
                .then(playlist => onSuccess(playlist))
                .catch(error => onError(error.message));
        }

        this.removeMusicaPlaylist = (musica, playlist, onSuccess, onError) => {
            return Playlist.deleteMusica(playlist.playlistId, musica.musicaId)
                .then(playlist => onSuccess(playlist))
                .catch(error => onError(error.message));
        }

        this.criaPlaylist = (playlist, onSuccess, onError) => {
            return Playlist.post(playlist)
                .then(playlist => onSuccess(playlist))
                .catch(error => onError(error.message));
        }
    });
})();