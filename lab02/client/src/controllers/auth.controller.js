(function () {
    'use strict';
    
    app.controller('authController', function (AuthService, NotificationService) {

        this.login = (userCredentials) => {
            AuthService.login(userCredentials, (token) => {
                console.log(token);
            }, (erro) => {
                NotificationService.error(erro);
            });
        }
    });
})();