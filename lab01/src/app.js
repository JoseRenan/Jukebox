const app = angular.module('jukeboxApp', ['ui.router', 'ngToast']);

app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/inicio');
    $stateProvider
        .state('inicio', {
            url: '/inicio',
            controller: 'musicaController',
            controllerAs: 'musicaCtrl',
            templateUrl: 'templates/views/musica.html'
        }).state('artistas', {
            url: '/artistas',
            controller: 'artistaController',
            controllerAs: 'artistaCtrl',
            templateUrl: 'templates/views/artista.html'
        });
});