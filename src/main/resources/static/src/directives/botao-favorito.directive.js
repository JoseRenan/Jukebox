(function () {
    'use strict';
    
    app.directive('botaoFavorito', function ($state, ArtistaService) {
        
        let link = (scope, element, attrs) => {
            scope.favoritarOuDesfavoritar = (avaliacaoArtista, artista) => {
                let resposta = confirm("Você realmente deseja fazer isso?");
                if (resposta) {
                    scope.avaliacaoArtista.favorito = !scope.avaliacaoArtista.favorito;
                    ArtistaService.avaliarArtista(artista.artistaId, avaliacaoArtista)
                        .then(avaliacaoArtistaAtualizada => (avaliacaoArtista = avaliacaoArtistaAtualizada));
                }
            }
        }

        return {
            restrict: 'E',
            link: link,
            scope: {
                artista: '=',
                avaliacaoArtista: '='
            },
            templateUrl: 'templates/directives/botao-favorito.html'
        };
    });
})();