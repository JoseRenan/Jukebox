(function () {
    'use strict';
    
    app.directive('albumsTable', function ($state) {
        return {
            restrict: 'E',
            scope: {
                albums: '='
            },
            templateUrl: 'templates/directives/albums-table.html'
        };
    });
})();