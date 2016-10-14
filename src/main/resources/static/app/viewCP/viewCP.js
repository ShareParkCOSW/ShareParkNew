'use strict';

angular.module('myApp.viewCP', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewCP', {
    templateUrl: 'viewCP/viewCP.html',
    controller: 'ViewCPCtrl'
  });
}])

.controller('ViewCPCtrl', ['$scope','getParkings', function($scope, getParkings) {

            getParkings.get(function(data){
                            console.info("get   ");
                            $scope.parkList=data;

            });
}]);