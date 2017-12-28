(function () {
    'use strict';
    
    app.service('UsuarioService', function (Usuario) {

        this.buscaUsuarioPorId = (idUsuario) => {
            return Usuario.get(idUsuario);
        }

        this.recuperarUsuarioAtual = () => {
            return Usuario.getByToken();
        }

        this.criaUsuario = (usuario, onSuccess, onError) => {
            return Usuario.post(usuario)
                .then(usuario => onSuccess(usuario))
                .catch(error => onError(error.message));
        }
    });
})();