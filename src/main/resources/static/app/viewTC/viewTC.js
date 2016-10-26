'use strict';

angular.module('myApp.viewTC', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewTC', {
    templateUrl: 'viewTC/viewTC.html',
    controller: 'ViewTCCtrl'
  });
}])

.controller('ViewTCCtrl', ['$scope','$rootScope','$http','$resource', function($scope, $rootScope, $http, $resource) {
    $scope.newCard=false;
    $scope.numTC=null;
    $scope.fechaVen="";
    $scope.cvv="";
    $scope.ccN={"cardNumber":null,"expirationDate":null,"cvcCode":null};


    $scope.addCreditCard = function(){

        infoCCs.get({idCC:""+$scope.numTC}, function(data){
                $scope.ccN=data;
                console.info($scope.ccN);
                });
        if ($scope.ccN.cardNumber==null){
            var newitem={"cardNumber":$scope.numTC,"expirationDate":$scope.fechaVen,"cvcCode":$scope,cvv};
            infoCCs.save(newitem,function(){});
        }else{
            console.info("La tarjeta de crédito ya existe!!!");
            $scope.newCard=true;
            $rootScope.valide=false;
        }
        };




}]);