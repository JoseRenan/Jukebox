(function () {
    'use strict';
    
    app.directive('botaoFavorito', function ($state) {
        
        let link = (scope, element, attrs) => {
            scope.favoritarOuDesfavoritar = () => {
                let resposta = confirm("Você realmente deseja fazer isso?");
                if (resposta) {
                    scope.ehFavorito = !scope.ehFavorito;
                }
            }
        }

        return {
            restrict: 'E',
            link: link,
            scope: {
                ehFavorito: '='
            },
            templateUrl: 'templates/directives/botao-favorito.html'
        };
    });
})();