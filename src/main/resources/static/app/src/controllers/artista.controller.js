(function () {
    'use strict';
    
    app.controller('artistaController', function (artistas, ArtistaService, NotificationService, $state) {
        
        this.artistas = artistas;

        this.salvaArtista = (artista) => {
            ArtistaService.salvarArtista(artista, () => {
                NotificationService.success('Artista salvo com sucesso');
                $state.reload();
            }, (erro) => {
                NotificationService.error(erro);
            });
        }
    });
})();