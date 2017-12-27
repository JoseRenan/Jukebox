(function () {
    'use strict';
    
    app.controller('authController', function (AuthService, UsuarioService, NotificationService, $state) {

        this.cadastro = (user, repeatPassword) => {
            if (user.password !== repeatPassword) {
                NotificationService.error("As senhas não coincidem!");
            } else {
                UsuarioService.criaUsuario(user, () => {
                    this.login(user);
                }, (erro) => {
                    NotificationService.error(erro);
                });
            }
        }

        this.login = (userCredentials) => {
            AuthService.login(userCredentials, (token) => {
                $state.go("home.musicas");
            }, (erro) => {
                NotificationService.error(erro);
            });
        }
    });
})();