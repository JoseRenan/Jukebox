(function () {
    'use strict';
    
    app.service('PlaylistService', function () {

        this.playlists = [{"musicas":[{"nome":"Shape of you","ano":2017,"duracao":"2:30","adicionada":true},{"nome":"Castle on the hill","ano":2017,"duracao":"2:30","adicionada":true}],"nome":"All of Ed Sheeran"}];

        this.buscaPlaylistPorNome = (nome) => {
            let buscaPlaylist = (playlist) => { return playlist.nome === nome };
            return this.playlists.find(buscaPlaylist);
        }

        let musicaAdicionada = (playlist, nomeMusica) => {
            let buscaMusica = (musica) => { return musica.nome === nomeMusica };
            return !!playlist.musicas.find(buscaMusica);
        }

        this.adicionaMusicaPlaylist = (musica, playlist, onSuccess, onError) => {
            if (!musicaAdicionada(playlist, musica.nome)) {
                playlist.musicas.push(musica);
                onSuccess();
            } else {
                onError("Música já cadastrada na playlist");
            }
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