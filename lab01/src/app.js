const app = angular.module('jukeboxApp', ['ui.router', 'ngToast', 'jkAngularRatingStars']);

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
        }).state('perfil', {
            url: '/perfil/:nome',
            controller: 'artistaPerfilController',
            controllerAs: 'perfilCtrl',
            templateUrl: 'templates/views/artista-perfil.html',
            resolve: {
                artista: function($stateParams, ArtistaService) {
                    return ArtistaService.buscaArtistaPorNome($stateParams.nome);
                }
            }
        }).state('playlists', {
            url: '/playlists',
            controller: 'playlistController',
            controllerAs: 'playlistCtrl',
            templateUrl: 'templates/views/playlist.html'
        }).state('detalhesPlaylist', {
            url: '/detalhes/:nomePlaylist',
            controller: 'playlistDetalhesController',
            controllerAs: 'detalhesCtrl',
            templateUrl: 'templates/views/playlist-detalhes.html',
            resolve: {
                playlist: function($stateParams, PlaylistService) {
                    return PlaylistService.buscaPlaylistPorNome($stateParams.nomePlaylist);
                }
            }
        });
});