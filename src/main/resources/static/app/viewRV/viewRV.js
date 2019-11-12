'use strict';

angular.module('myApp.viewRV', ['ngRoute','ngResource'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRV', {
    templateUrl: 'viewRV/viewRV.html',
    controller: 'ViewRVCtrl'
  });
}])

.controller('ViewRVCtrl', ['$scope', '$rootScope','$http','$resource', 'vehicles', 'user', function($scope, $rootScope,$http,$resource,vehicles, user) {
        $scope.plate=null;
        $scope.brand=null;
        $scope.model=null;
        $scope.color=null;
        $scope.vehicleType=null;
        $scope.owner_id=null;
        $scope.busy=false;

        $scope.vehicleTypeOpt = {
            availableOptions: [
                {name: 'Automovil'},
                {name: 'Campero'},
                {name: 'Camioneta o Pickup'},
                {name: 'Van'},
                {name: 'Mini van'}
            ]
        };



        $scope.registrarVehicle = function(){
            $scope.busy=true;
            user.get({iduser:""+$scope.owner_id})
            .$promise.then(
                    //success
                    function( value ){
                        vehicles.get({plate:""+$scope.plate})
                        .$promise.then(
                            //success
                            function( value ){
                                alert("El vehículo con placa: "+$scope.plate+" ya está registrado!!!");
                                $scope.busy=false;
                            },
                            //error
                            function( error ){
                                var newitem={"plate": $scope.plate,"brand":$scope.brand, "model":$scope.model,"color": $scope.color, "vehicleType":$scope.vehicleType, "owner_id":$scope.owner_id};
                                vehicles.save(newitem)
                                .$promise.then(
                                    function(value){
                                        alert("El vehículo con placa: "+$scope.plate+" fue registrado satisfactoriamente!!!");
                                        $scope.plate=null;
                                        $scope.brand=null;
                                        $scope.model=null;
                                        $scope.color=null;
                                        $scope.vehicleType=null;
                                        $scope.owner_id=null;
                                        $scope.busy=false;
                                    },
                                    function(error){
                                        alert("El vehiculo no se pudo registrar debido a inconsistencia en los datos!!!");
                                        $scope.busy=false;
                                    }
                                );
                            }
                        );
                    },
                    //error
                    function( error ){
                        alert("El ID: "+$scope.owner_id+" no está registrado!!!");
                        $scope.busy=false;
                    }
            );
        };
}]);