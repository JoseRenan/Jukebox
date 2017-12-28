(function () {
    'use strict';
    
    app.controller('artistaPerfilController', function (musicas, artista, musicaOuvida, albums, avaliacaoArtista, OuvirService, NotificationService, ArtistaService) {

        this.albums = albums;
        this.artista = artista;
        this.musicas = musicas;
        this.musicaOuvida = musicaOuvida;
        this.avaliacaoArtista = avaliacaoArtista;

        this.numeroDeMusicas = () => {
            return musicas.length;
        }

        this.ouvir = (musica) => {
            OuvirService.ouvir(musica, (musicaRecebida) => {
                this.musicaOuvida = musicaRecebida;
            }, (mensagem) => {
                NotificationService.error(`Erro ao ouvir. ${mensagem}`);
            });
        }

        this.onRating = (avaliacaoArtista) => {
            ArtistaService.avaliarArtista(this.artista.artistaId, avaliacaoArtista)
                .then(avaliacaoArtista => (this.avaliacaoArtista = avaliacaoArtista));
        }

    });
})();