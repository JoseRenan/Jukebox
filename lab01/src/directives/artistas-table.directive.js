(function () {
    'use strict';
    
    app.directive('artistasTable', function ($state) {
        
        let link = (scope, element, attrs) => {
            
        }

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