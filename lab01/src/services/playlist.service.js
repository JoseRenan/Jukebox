(function () {
    'use strict';
    
    app.service('PlaylistService', function () {

        this.playlists = [];

        this.buscaPlaylistPorNome = (nome) => {
            let buscaPlaylist = (playlist) => { return playlist.nome === nome };
            return this.playlists.find(buscaPlaylist);
        }

        let musicaAdicionada = (playlist, nomeMusica) => {
            let buscaMusica = (musica) => { return musica.nome === nomeMusica };
            return !!this.playlist.musicas.find(buscaMusica);
        }

        this.criaPlaylist = (playlist, onSuccess, onError) => {
            if (!this.buscaPlaylistPorNome(playlist.nome)) {
                this.playlists.push(playlist);
                onSuccess();
            } else {
                onError("Playlist já cadastrada");
            }
        }
    });
})();