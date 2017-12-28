(function () {
    'use strict';
    
    app.service('Musica', function (API, $http) {

        this.url = API.getResourceUrl('/musicas');

        this.get = (id) => {
            if (id) {
                return $http.get(`${this.url}/${id}`)
                    .then(API.successCallback)
                    .catch(API.errorCallback);
            }
        }

        this.ouvir = (id) => {
            return $http.get(`${this.url}/${id}/ouvir`)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.ultimaOuvida = (id) => {
            return $http.get(`${this.url}/artista/${id}/ouvidas`)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.query = ({nome, idArtista} = {}) => {
            let data = {params: {}};
            if (nome) {
                data.params.nome = nome;
            } if (idArtista) {
                data.params.idArtista = idArtista;
            }
            return $http.get(this.url, data)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.post = (musica) => {
            return $http.post(this.url, musica)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }
    });
})();