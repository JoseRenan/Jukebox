(function () {
    'use strict';
    
    app.controller('artistaController', function (ArtistaService, NotificationService) {
        
        this.artistas = ArtistaService.artistas;

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