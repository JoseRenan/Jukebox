(function () {
    'use strict';
    
    app.service('AuthService', function (Auth, $window) {
        this.login = (userCredentials, onSuccess, onError) => {
            return Auth.signIn(userCredentials)
                .then(token => {
                    console.log(token);
                    $window.sessionStorage.token = token;
                    onSuccess(token);
                })
                .catch(error => onError(error.message));
        }

        this.getToken = () => {
            return $window.sessionStorage.token;
        }
    });
})();