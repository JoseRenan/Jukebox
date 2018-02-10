(function () {
    'use strict';
    
    app.factory('API', function ($q) {
        return {
            getResourceUrl: (resourcePath) => {
                let BASE_URL = 'https://jukebox-si.herokuapp.com';
                return BASE_URL + resourcePath;
            }, 
            successCallback: (response) => {
                return response.data;
            },
            errorCallback: (response) => {
                let q = $q.defer();
                if(response.data.message) {
                    q.reject(response.data);
                } else {
                    q.reject({message: 'Ocorreu um erro ao se comunicar com o servidor, Tente novamente mais tarde'});
                }
                return q.promise;
            }
        }
    });
})();