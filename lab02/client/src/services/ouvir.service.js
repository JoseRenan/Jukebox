(function () {
    'use strict';
    
    app.service('OuvirService', function (Musica) {
        this.ouvir = (musica, onSuccess, onError) => {
            return Musica.ouvir(musica.musicaId)
                .then(musica => onSuccess(musica))
                .catch(error => onError(error.message));
        }

        this.ultimaOuvida = (artistaId) => {
            return Musica.ultimaOuvida(artistaId);
        }
    });
})();