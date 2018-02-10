(function () {
    'use strict';
    
    app.directive('musicasPlaylistTable', function ($state) {
        return {
            restrict: 'E',
            scope: {
                musicas: '=',
                playist: '=',
                acao: '&',
                filterText: '='
            },
            templateUrl: 'templates/directives/musicas-playlist-table.html'
        };
    });
})();