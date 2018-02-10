(function () {
    'use strict';
    
    app.service('Usuario', function (API, $http) {

        this.url = API.getResourceUrl('/usuarios');

        this.get = (id) => {
            if (id) {
                return $http.get(`${this.url}/${id}`)
                    .then(API.successCallback)
                    .catch(API.errorCallback);
            }
        }

        this.getByToken = () => {
            return $http.get(`${this.url}/token`)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }

        this.post = (usuario) => {
            return $http.post(this.url, usuario)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }
    });
})();