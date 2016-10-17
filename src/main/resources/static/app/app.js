'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'myApp.view2',
    'myApp.loginView',
    'myApp.viewTC',
    'myApp.viewRP',
    'myApp.viewCP',
    'services.factory',
    //'services.parking',
    'myApp.version'
]).
config(['$locationProvider','$httpProvider', '$routeProvider', function($locationProvider, $httpProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.otherwise({redirectTo: '/loginView'});
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])
.controller('LogoutCtrl', ['$rootScope', '$scope', '$http' , '$location',function($rootScope, $scope, $http , $location) {
               $scope.logout = function () {
                               $http.post('/logout', {}).success(function () {
                                   $rootScope.authenticated = false;
                                   $location.path("/");
                               }).error(function (data) {
                                   $rootScope.authenticated = false;
                               });
                           };
}]);
