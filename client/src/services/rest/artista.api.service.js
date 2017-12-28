(function () {
    'use strict';
    
    app.service('Artista', function (API, $http) {

        this.url = API.getResourceUrl('/artistas');

        this.get = (id) => {
            if (id) {
                return $http.get(`${this.url}/${id}`)
                    .then(API.successCallback)
                    .catch(API.errorCallback);
            }
        }

        this.put = (id, avaliacaoArtista) => {
            return $http.put(`${this.url}/${id}/avaliacao`, avaliacaoArtista)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.getAvaliacao = (id) => {
            return $http.get(`${this.url}/${id}/avaliacao`)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.query = (nome) => {
            let data = {params: {}};
            if (nome) {
                data.params.nome = nome;
            }
            return $http.get(this.url, data)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.post = (artista) => {
            return $http.post(this.url, artista)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }
    });
})();