'use strict';

angular.module('myApp.viewRV', ['ngRoute','ngResource'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRV', {
    templateUrl: 'viewRV/viewRV.html',
    controller: 'ViewRVCtrl'
  });
}])

.controller('ViewRVCtrl', ['$scope', '$rootScope','$http','$resource', 'vehicles', function($scope, $rootScope,$http,$resource,vehicles) {
        $scope.plate=null;
        $scope.brand=null;
        $scope.model=null;
        $scope.color=null;
        $scope.vehicleType=null;
        $scope.owner_id=null;

        $scope.registrarVehicle = function(){
            vehicles.get({plate:""+$scope.plate})
            .$promise.then(
                    //success
                    function( value ){
                        alert("El vehículo con placa: "+$scope.plate+" ya está registrado!!!");
                    },
                    //error
                    function( error ){
                        var newitem={"plate": $scope.plate,"brand":$scope.brand, "model":$scope.model,"color": $scope.color, "vehicleType":$scope.vehicleType, "owner_id":$scope.owner_id};
                        vehicles.save(newitem,function(){});
                        alert("El vehículo con placa: "+$scope.plate+" fue registrado satisfactoriamente!!!");
                        $scope.plate=null;
                        $scope.brand=null;
                        $scope.model=null;
                        $scope.color=null;
                        $scope.vehicleType=null;
                        $scope.owner_id=null;
                    }
            );
        };
}]);