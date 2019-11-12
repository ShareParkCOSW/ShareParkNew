'use strict';

angular.module('myApp.CrearEstudiante', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CrearEstudiante', {
    templateUrl: 'CrearEstudiante/CrearEstudiante.html',
    controller: 'CrearEstudianteCtrl'
  });
}])

.controller('CrearEstudianteCtrl', ['$rootScope', '$scope', '$location', 'tiposdeidentificacion', 'estudiante', 'newEstudiante',  function ($rootScope, $scope,$location,tiposdeidentificacion,estudiante, newEstudiante) {

    $scope.tipoDeIdentificacion=null;
    $scope.tiposId=[];
    $scope.numeroDeIdentificacion=null;
    $scope.nombre=null;
    $scope.codigo=null;
    tiposdeidentificacion.get()
        .$promise.then(
        //success
        function( value ){
            for(var i=0;i<value.length; i++){
                $scope.tiposId.push({"label":value[i].sigla,
                    "value":value[i].idTipoDeIdentificacion});
            }
        },
        //error
        function( error ){}
    );

    $scope.save= function(){
        $scope.busy=true;
        $scope.estudiante={
            "idEstudiante":$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion,
            "idTipoDeIdentificacion":$scope.tipoDeIdentificacion,
            "numeroDeIdentificacion":$scope.numeroDeIdentificacion,
            "nombre":$scope.nombre,
            "codigo":$scope.codigo
        };
        estudiante.get({idestudiante:$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion})
            .$promise.then(
            //success
            function( value ){
                alert("Ya existe un estudiante registrado para los datos de identificación dados");
                $scope.busy=false;
            },
            //error
            function( error ){
                newEstudiante.save($scope.estudiante)
                    .$promise.then(
                    function(value){
                        alert("Nuevo estudiante creado exitosamente");
                        $location.path("Home");
                        $scope.busy=false;
                    },
                    function(error){
                        alert("El estudiante no fue guardado");
                        $scope.busy=false;
                    }
                );
            }
        );
    };
}]);