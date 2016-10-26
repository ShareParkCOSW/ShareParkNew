'use strict';

angular.module('myApp.viewCP', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewCP', {
    templateUrl: 'viewCP/viewCP.html',
    controller: 'ViewCPCtrl'
  });
}])

.controller('ViewCPCtrl', ['$scope','parkings', function($scope, parkings) {
    $scope.busy=true;
    parkings.get(function(data){
        $scope.parkList=data;
        $scope.busy=false;
    });
}]);