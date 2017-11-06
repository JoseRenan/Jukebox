(function () {
    'use strict';
    
    app.directive('albumsTable', function ($state) {
        
        let link = (scope, element, attrs) => {

            let stringMinutosEmSegundos = (duracao) => {
                let array = duracao.split(':');
                return (parseInt(array[0]) * 60) + parseInt(array[1]);
            }

            let segundosEmString = (segundos) => {
                let minutos = Match.floor(segundos/60);
                let segundosRestantes = segundos % 60;
                return minutos + ':' + segundosRestantes;
            }

            scope.duracaoTotal = (album) => {
                let total = 0;
                for (let musica in album.musicas) {
                    console.log(musica);
                    total += stringMinutosEmSegundos(musica.duracao);
                }
                return segundosEmString(total);
            }
        }

        return {
            restrict: 'E',
            link: link,
            scope: {
                albums: '='
            },
            templateUrl: 'templates/directives/albums-table.html'
        };
    });
})();