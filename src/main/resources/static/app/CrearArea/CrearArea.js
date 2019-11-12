'use strict';

angular.module('myApp.CrearArea', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CrearArea', {
    templateUrl: 'CrearArea/CrearArea.html',
    controller: 'CrearAreaCtrl'
  });
}])

.controller('CrearAreaCtrl', ['$rootScope', '$scope', '$location', 'areaNombre', 'newArea',  function ($rootScope, $scope,$location,areaNombre, newArea) {

    $scope.nombre=null;
    $scope.intensidadHoraria=null;

    $scope.save= function(){
        $scope.busy=true;
        $scope.area={
            "nombre":$scope.nombre,
            "intensidadHoraria":$scope.intensidadHoraria
        };
        areaNombre.get({nombre:$scope.nombre})
            .$promise.then(
            //success
            function( value ){
                alert("Ya existe un área con ese nombre");
                $scope.busy=false;
            },
            //error
            function( error ){
                newArea.save($scope.area)
                    .$promise.then(
                    function(value){
                        alert("Nueva área creada exitosamente");
                        $location.path("Home");
                        $scope.busy=false;
                    },
                    function(error){
                        alert("El área no fue guardada");
                        $scope.busy=false;
                    }
                );
            }
        );
    };
}]);