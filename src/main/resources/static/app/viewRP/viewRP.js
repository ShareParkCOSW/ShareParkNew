'use strict';

angular.module('myApp.viewRP', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRP', {
    templateUrl: 'viewRP/viewRP.html',
    controller: 'ViewRPCtrl'
  });
}])

.controller('ViewRPCtrl', ['$scope','postParking', function($scope, postParking) {

    $scope.ownerId="";
    $scope.covert="";
    $scope.home="";
    $scope.height="";
    $scope.width="";
    $scope.length="";
    $scope.available="";
    $scope.serviceStart="";
    $scope.availableFinish="";
    $scope.costMinute="";
    $scope.address="";
    $scope.stratum="";


    $scope.registerParking= function(){

        var newitem={"ownerId":$scope.ownerId,"covert":$scope.covert,"home":$scope,home,
                      "height":$scope.height,"width":$scope.width,"length":$scope,length,
                      "available":$scope.available,"serviceStart":$scope.serviceStart,"availableFinish":$scope,availableFinish,
                      "costMinute":$scope.costMinute,"address":$scope.address,"stratum":$scope.stratum};

        postParking.save(newitem,function(){
            console.info("Parking saved   "+ newitem);
            });
            }
}]);