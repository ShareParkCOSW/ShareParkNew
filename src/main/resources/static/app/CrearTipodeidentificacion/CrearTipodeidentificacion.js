'use strict';

angular.module('myApp.CrearTipodeidentificacion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CrearTipodeidentificacion', {
    templateUrl: 'CrearTipodeidentificacion/CrearTipodeidentificacion.html',
    controller: 'CrearTipodeidentificacionCtrl'
  });
}])

.controller('CrearTipodeidentificacionCtrl', ['$rootScope', '$scope', '$location', 'tipodeidentificacionBySigla', 'newTipodeidentificacion',  function ($rootScope, $scope,$location,tipodeidentificacionBySigla, newTipodeidentificacion) {

    $scope.sigla=null;
    $scope.descripcion=null;

    $scope.save= function(){
        $scope.busy=true;
        $scope.tipoDeIdentificacion={
            "sigla":$scope.sigla,
            "descripcion":$scope.descripcion
        };
        tipodeidentificacionBySigla.get({sigla:$scope.sigla})
            .$promise.then(
            //success
            function( value ){
                alert("Ya existe un tipo de identificación con esa sigla");
                $scope.busy=false;
            },
            //error
            function( error ){
                newTipodeidentificacion.save($scope.tipoDeIdentificacion)
                    .$promise.then(
                    function(value){
                        alert("Nueva tipo de identificación creado exitosamente");
                        $location.path("Home");
                        $scope.busy=false;
                    },
                    function(error){
                        alert("El tipo de identificación no fue guardado");
                        $scope.busy=false;
                    }
                );
            }
        );
    };
}]);