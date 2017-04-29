'use strict';

angular
    .module('ring')
    .controller('HomeController', HomeController);

function HomeController($route, $scope, $http) {

    $scope.newRing = {};


    $scope.add = function (newRing) {

        $http.post('/api/ring', newRing).then(function () {
            $route.reload();
        });

    };

    $scope.delete = function (deleteId) {
        $http.delete('/api/ring/'+deleteId).then(function () {
            $route.reload();
        });

    };

    $http.get('/people').then(function (response) {
        $scope.rings = response.data;
    });
}