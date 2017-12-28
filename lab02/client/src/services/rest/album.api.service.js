(function () {
    'use strict';
    
    app.service('Album', function (API, $http) {

        this.url = API.getResourceUrl('/albums');

        this.query = (artistaId) => {
            return $http.get(`${this.url}/artistas/${artistaId}`)
                .then(API.successCallback)
                .catch(API.errorCallback);
        }
    });
})();