(function () {
    'use strict';
    
    app.service('OuvirService', function () {

        this.ouvir = (artista, musica) => {
            artista.ultimaMusicaOuvida = musica;
        }
    });
})();