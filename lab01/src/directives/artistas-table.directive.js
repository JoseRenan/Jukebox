(function () {
    'use strict';
    
    app.directive('artistasTable', function ($state) {
        return {
            restrict: 'E',
            link: link,
            scope: {
                artistas: '='
            },
            templateUrl: 'templates/directives/artistas-table.html'
        };
    });
})();