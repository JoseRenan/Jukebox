(function () {
    'use strict';
    
    app.service('AlbumService', function (Album) {
        this.buscaAlbumPorArtista = (artistaId) => {
            return Album.query(artistaId);
        }
    });
})();