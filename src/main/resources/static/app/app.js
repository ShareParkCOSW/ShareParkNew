'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'myApp.loginView',
    'myApp.Register',
    'myApp.Home',
    'myApp.TemplateHome',
    'myApp.CrearEstudiante',
    'myApp.ActualizarEstudiante',
    'myApp.CrearFuncionario',
    'myApp.ActualizarFuncionario',
    'myApp.CrearArea',
    'myApp.ActualizarArea',
    'myApp.CrearAsignatura',
    'myApp.ActualizarAsignatura',
    'myApp.CrearTipodeidentificacion',
    'myApp.ActualizarTipodeidentificacion',
    'myApp.ActualizarAdmin',
    'myApp.CrearInforme',
    'services.factory',
    'myApp.version'
]).
config(['$locationProvider','$httpProvider', '$routeProvider', function($locationProvider, $httpProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.otherwise({redirectTo: '/loginView'});
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])
.controller('LogoutCtrl', ['$rootScope', '$scope', '$http' , '$location',function($rootScope, $scope, $http , $location) {
   $scope.logout = function () {
       $location.path("/");
   };
}]);
