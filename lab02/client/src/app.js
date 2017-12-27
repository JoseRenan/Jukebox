const app = angular.module('jukeboxApp', ['ui.router', 'ngToast', 'jkAngularRatingStars']);

app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('login', {
            url: '/',
            controller: 'authController',
            controllerAs: 'authCtrl',
            templateUrl: 'templates/views/login.html'
        }).state('home', {
            url: '/home',
            abstract: true,
            templateUrl: 'templates/views/home.html',
        }).state('home.musicas', {
            url: '/musicas',
            controller: 'musicaController',
            controllerAs: 'musicaCtrl',
            templateUrl: 'templates/views/musica.html',
            resolve: {
                artistas: function(ArtistaService) {
                    return ArtistaService.listarArtistas()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        }).state('home.artistas', {
            url: '/artistas',
            controller: 'artistaController',
            controllerAs: 'artistaCtrl',
            templateUrl: 'templates/views/artista.html',
            resolve: {
                artistas: function(ArtistaService) {
                    return ArtistaService.listarArtistas()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        }).state('home.perfil', {
            url: '/perfil/:artistaId',
            controller: 'artistaPerfilController',
            controllerAs: 'perfilCtrl',
            templateUrl: 'templates/views/artista-perfil.html',
            resolve: {
                artista: function($stateParams, ArtistaService) {
                    return ArtistaService.recuperarArtista($stateParams.artistaId)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                musicas: function($stateParams, MusicaService) {
                    return MusicaService.listarMusicasPorArtista($stateParams.artistaId)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        }).state('home.playlists', {
            url: '/playlists',
            controller: 'playlistController',
            controllerAs: 'playlistCtrl',
            templateUrl: 'templates/views/playlist.html',
            resolve: {
                musicas: function(MusicaService) {
                    return MusicaService.listarMusicas()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                playlists: function(PlaylistService) {
                    return PlaylistService.listarPlaylists()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        }).state('home.detalhesPlaylist', {
            url: '/detalhes/:idPlaylist',
            controller: 'playlistDetalhesController',
            controllerAs: 'detalhesCtrl',
            templateUrl: 'templates/views/playlist-detalhes.html',
            resolve: {
                playlist: function($stateParams, PlaylistService) {
                    return PlaylistService.buscaPlaylistPorId($stateParams.idPlaylist)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                musicas: function(MusicaService) {
                    return MusicaService.listarMusicas()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        });
});