(function () {
    'use strict';
    
    app.service('ArtistaService', function (Artista) {
        
        this.artistas = [{
            "nome":"Ed Sheeran",
            "linkFoto":"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ7EYhQPsC4cWLjXm3z5v6yKJxZgtqAEqEPyY4K7ipc1Rih-XGoA",
            "albums":[{
                "nome": "Divide",
                "musicas": [{
                    "nome": "Shape of you",
                    "ano": 2017,
                    "duracao": "2:30"
                }, {
                    "nome": "Castle on the hill",
                    "ano": 2017,
                    "duracao": "2:30"
                }]
            }]
        }];

        this.listarArtistas = () => {
            return Artista.query();
        }

        this.buscaArtistaPorNome = (nome) => {
            return Artista.query(nome).then((artista) => {
                return artista;
            });
        }

        this.recuperarArtista = (artistaId) => {
            return Artista.get(artistaId).then((artista) => {
                return artista;
            });
        }

        let buscaAlbumPorNome = (artista, nomeAlbum) => {
            let buscaAlbum = (album) => { return album.nome === nomeAlbum };
            return artista.albums.find(buscaAlbum);
        }

        let musicaJaAdicionada = (nomeMusica, nomeAlbum, artista) => {
            let album = buscaAlbumPorNome(artista, nomeAlbum);
            if (album) {
                let buscaMusica = (musica) => { return musica.nome === nomeMusica };
                return !!album.musicas.find(buscaMusica);
            }
            return false;
        }

        let salvaMusicaEmAlbum = (artista, nomeAlbum, musica) => {
            let albumSalvo = buscaAlbumPorNome(artista, nomeAlbum);
            if (albumSalvo) {
                albumSalvo.musicas.push(musica);
            } else {
                let album = {
                    nome: nomeAlbum,
                    musicas: [musica]
                }
                artista.albums.push(album);
            }
        }

        this.salvarArtista = (artista, onSuccess, onError) => {
            Artista.post(artista)
                .then(artista => onSuccess())
                .catch(erro => onError(erro.message));
        }

        this.salvarMusicaEmArtista = (musica, nomeAlbum, artista, onSuccess, onError) => {
            let artistaSalvo = this.buscaArtistaPorNome(artista.nome);
            if (!artistaSalvo) {
                onError("Artista inexistente");
            } else if (musicaJaAdicionada(musica.nome, nomeAlbum, artista)) {
                onError("Música já inserida no álbum");
            } else {
                salvaMusicaEmAlbum(artistaSalvo, nomeAlbum, musica);
                onSuccess();
            }
        }
    });
})();