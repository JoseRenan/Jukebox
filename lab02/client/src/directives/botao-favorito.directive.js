(function () {
    'use strict';
    
    app.directive('botaoFavorito', function ($state, ArtistaService) {
        
        let link = (scope, element, attrs) => {
            scope.favoritarOuDesfavoritar = (artista) => {
                let resposta = confirm("Você realmente deseja fazer isso?");
                if (resposta) {
                    scope.artista.favorito = !scope.artista.favorito;
                    ArtistaService.atualizarArtista(artista.artistaId, artista)
                        .then(artistaAtualizado => (artista = artistaAtualizado));
                }
            }
        }

        return {
            restrict: 'E',
            link: link,
            scope: {
                artista: '='
            },
            templateUrl: 'templates/directives/botao-favorito.html'
        };
    });
})();