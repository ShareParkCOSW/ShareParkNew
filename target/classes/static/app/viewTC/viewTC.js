'use strict';

angular.module('myApp.viewTC', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewTC', {
    templateUrl: 'viewTC/viewTC.html',
    controller: 'ViewTCCtrl'
  });
}])

.controller('ViewTCCtrl', ['$scope','infoCCs', function($scope, infoCCs) {

    $scope.numTC="";
    $scope.fechaVen="";
    $scope.cvv="";


    $scope.agregarFabrica = function(){

        var newitem={"numTC":$scope.numTC,"fechaVen":$scope.fechaVen,"cvv":$scope,cvv};

        infoCCs.save(newitem,function(){
            console.info("saved   "+ newitem);
            });

            //service1.addTodo({propiedad1:$scope.propiedad1,propiedad2:$scope.propiedad2});
            $scope.description="";
            $scope.priority="";
            //alert("Sent!!");
            }




    /*$scope.saveCCInfo = function() {
    		var numTC = $scope.numTC;
    		var fechaVen = $scope.fechaVen;
    		var cvv = $scope.cvv;
    		var infoCCs = [
    			numTC,
    			fechaVen,
    			cvv
    		];
    		fabrica1.addTodo(infoCCs);
    	}*/



}]);