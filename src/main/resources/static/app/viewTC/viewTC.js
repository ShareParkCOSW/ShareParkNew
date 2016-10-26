'use strict';

angular.module('myApp.viewTC', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewTC', {
    templateUrl: 'viewTC/viewTC.html',
    controller: 'ViewTCCtrl'
  });
}])

.controller('ViewTCCtrl', ['$scope','$rootScope','$http','$resource','creditCardById','creditCards','user', function($scope, $rootScope, $http, $resource,creditCardById, creditCards,user) {

    $scope.numTC=null;
    $scope.fechaVen="";
    $scope.cvv="";
    $scope.userId=null;


    $scope.addCreditCard = function(){
        $scope.busy=true;
        $scope.venc=($scope.fechaVen.getMonth()+1)+"/"+($scope.fechaVen.getFullYear().toString()).slice(2,4);
        var newitem={"cardNumber":$scope.numTC,"expirationDate":$scope.venc,"cvcCode":$scope.cvv, "owner_id":$scope.userId};
         user.get({iduser:""+$scope.userId})
             .$promise.then(
                     //success
                     function( value ){
                         creditCardById.get({cardNumber:""+$scope.numTC})
                         .$promise.then(
                                 //success
                                 function( value ){
                                     alert("Ya existe una tarjeta de credito con numero: "+$scope.numTC+"!!!");
                                     $scope.busy=false;
                                 },
                                 //error
                                 function( error ){
                                     creditCards.save(newitem)
                                     .$promise.then(
                                         function(value){
                                             alert("La tarjeta de credito fue registrada satisfactoriamente!!!");
                                             $scope.numTC=null;
                                             $scope.fechaVen="";
                                             $scope.cvv="";
                                             $scope.userId=null;
                                             $scope.busy=false;
                                         },
                                         function(error){
                                             alert("La tarjeta de credito no se pudo registrar debido a inconsistencia en los datos!!!");
                                             $scope.busy=false;
                                         }
                                     );
                                 }
                         );
                     },
                     //error
                     function( error ){
                         alert("El ID: "+$scope.userId+" no está registrado!!!");
                         $scope.busy=false;
                     }
             );
     };

}]);