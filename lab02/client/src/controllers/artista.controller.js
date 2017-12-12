(function () {
    'use strict';
    
    app.controller('artistaController', function (artistas, ArtistaService, NotificationService) {
        
        this.artistas = artistas;

        this.salvaArtista = (artista) => {
            ArtistaService.salvarArtista(artista, () => {
                delete this.artista;
                NotificationService.success('Artista salvo com sucesso');
            }, (erro) => {
                NotificationService.error(erro);
            });
        }
    });
})();