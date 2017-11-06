(function () {
    'use strict';
    
    app.controller('artistaPerfilController', function (ArtistaService, NotificationService, artista) {
        
        this.artistas = ArtistaService.artistas;
        this.artista = artista;
        console.log("BBBBBBBBBB");

        this.salvaArtista = (artista) => {
            ArtistaService.salvar(artista, () => {
                delete this.artista;
                NotificationService.success('Artista salvo com sucesso');
            }, () => {
                NotificationService.error('Erro ao cadastrar, artista já existe');
            });
        }
    });
})();