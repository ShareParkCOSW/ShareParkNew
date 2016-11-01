'use strict';

angular.module('myApp.viewRP', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewRP', {
    templateUrl: 'viewRP/viewRP.html',
    controller: 'ViewRPCtrl'
  });
}])

.controller('ViewRPCtrl', ['$scope','parkings', 'user', 'parkingByAdd', function($scope, parkings, user, parkingByAdd) {

    $scope.owner_id="";
    $scope.covert=false;
    $scope.home=false;
    $scope.height="";
    $scope.width="";
    $scope.length="";
    $scope.costMinute="";
    $scope.address="";
    $scope.stratum=3;
    $scope.busy=false;
    $scope.x=0.5;
    $scope.y=0.5;

    $scope.registerParking= function(){
        $scope.busy=true;
        var newitem={"owner_id":$scope.owner_id,"covert":$scope.covert,"home":$scope.home,
                      "height":$scope.height,"width":$scope.width,"length":$scope.length,
                      "costMinute":$scope.costMinute,"address":$scope.address,"stratum":$scope.stratum, "y":$scope.y, "x":$scope.x};


        user.get({iduser:""+$scope.owner_id})
        .$promise.then(
                //success
                function( value ){
                    parkingByAdd.get({idparking:""+$scope.address+"/exists"})
                    .$promise.then(
                            //success
                            function( value ){
                                alert("Ya existe un estacionamiento registrado en la dirección: "+$scope.address+"!!!");
                                $scope.busy=false;
                            },
                            //error
                            function( error ){
                                parkings.save(newitem)
                                .$promise.then(
                                    function(value){
                                        alert("El estacionamiento fue registrado satisfactoriamente!!!");
                                        $scope.owner_id="";
                                        $scope.covert=false;
                                        $scope.home=false;
                                        $scope.height="";
                                        $scope.width="";
                                        $scope.length="";
                                        $scope.costMinute="";
                                        $scope.address="";
                                        $scope.stratum=3;
                                        $scope.busy=false;
                                    },
                                    function(error){
                                        alert("El estacionamiento no se pudo registrar debido a inconsistencia en los datos!!!");
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
    }
}]);