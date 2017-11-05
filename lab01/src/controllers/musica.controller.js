(function () {
    'use strict';
    
    app.controller('musicaController', function (ArtistaService) {
        
        this.artistas = ArtistaService.artistas;

    });
})();