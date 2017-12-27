(function () {
    'use strict';
    
    app.service('Auth', function (API, $http) {

        this.url = API.getResourceUrl('/login');

        this.signIn = (userCredentials) => {
            return $http.post(`${this.url}/`, userCredentials)
                .then((reponse) => {
                    return response.headers("Authorizarion");
                }).catch(API.errorCallback);
        }
    });
})();