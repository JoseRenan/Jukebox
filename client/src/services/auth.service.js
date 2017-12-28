(function () {
    'use strict';
    
    app.service('AuthService', function (Auth, $window) {
        this.login = (userCredentials, onSuccess, onError) => {
            return Auth.signIn(userCredentials)
                .then(token => {
                    $window.sessionStorage.token = token;
                    onSuccess(token);
                })
                .catch(error => onError(error.message));
        }

        this.logout = (onSuccess, onError) => {
            delete $window.sessionStorage.token;
            onSuccess();
        }
    });
})();