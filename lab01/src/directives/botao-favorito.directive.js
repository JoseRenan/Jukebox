(function () {
    'use strict';
    
    app.directive('botaoFavorito', function ($state) {
        
        let link = (scope, element, attrs) => {
            scope.favoritarOuDesfavoritar = () => {
                scope.ehFavorito = !scope.ehFavorito;
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