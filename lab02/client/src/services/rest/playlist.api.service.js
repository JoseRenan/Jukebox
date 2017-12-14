(function () {
    'use strict';
    
    app.service('Playlist', function (API, $http) {

        this.url = API.getResourceUrl('/playlists');

        this.get = (id) => {
            if (id) {
                return $http.get(`${this.url}/${id}`)
                    .then(API.successCallback)
                    .catch(API.errorCallback);
            }
        }

        this.query = () => {
            return $http.get(this.url)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.post = (playlist) => {
            return $http.post(this.url, playlist)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.postMusica = (playlistId, musica) => {
            return $http.post(`${this.url}/${playlistId}/musicas`, musica)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.deleteMusica = (playlistId, musicaId) => {
            return $http.delete(`${this.url}/${playlistId}/musicas/${musicaId}`)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }
    });
})();