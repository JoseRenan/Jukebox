(function () {
    'use strict';
    
    app.controller('userController', function (AuthService, NotificationService, $state, usuario) {
        this.usuario = usuario;
        this.logout = () => {
            AuthService.logout(() => {
                $state.go("login");
            }, (erro) => {
                NotificationService.error(erro);
            });
        }
    });
})();