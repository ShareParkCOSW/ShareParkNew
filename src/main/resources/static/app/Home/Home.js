'use strict';

angular.module('myApp.Home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Home', {
    templateUrl: 'Home/Home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl', ['$rootScope', '$scope', 'admin', '$location', function ($rootScope, $scope, admin,$location) {

    admin.get({idadmin:""+$rootScope.idAdminGlobal})
        .$promise.then(
        //success
        function( value ){
            $scope.admin=value;

        },
        //error
        function( error ){
            alert("El Identificador no se encuentra registrado");
        }
    );
}]);