'use strict';

angular.module('myApp.ActualizarEstudiante', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ActualizarEstudiante', {
    templateUrl: 'ActualizarEstudiante/ActualizarEstudiante.html',
    controller: 'ActualizarEstudianteCtrl'
  });
}])

.controller('ActualizarEstudianteCtrl', ['$rootScope', '$scope', '$location', 'tiposdeidentificacion', 'estudiante', 'estudiantes',  function ($rootScope, $scope,$location,tiposdeidentificacion,estudiante, estudiantes) {

    $scope.showForm=false;
    $scope.tipoDeIdentificacion=null;
    $scope.tiposId=[];
    $scope.numeroDeIdentificacion=null;
    $scope.tipoDeIdentificacionFind=null;
    $scope.numeroDeIdentificacionFind=null;
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

    $scope.findEstudiante=function(){
        $scope.busy=true;
        estudiante.get({idestudiante:$scope.tipoDeIdentificacionFind+"-"+$scope.numeroDeIdentificacionFind})
            .$promise.then(
            //success
            function( value ){
                $scope.tipoDeIdentificacion=value.tipoDeIdentificacion;
                $scope.numeroDeIdentificacion=value.numeroDeIdentificacion;
                $scope.nombre=value.nombre;
                $scope.codigo=value.codigo;
                $scope.busy=false;
                $scope.showForm=true;
            },
            //error
            function( error ){
                alert("No existe un estudiante con ese número de identificación");
                $scope.busy=false;
            }
        );
    }

    $scope.actualizarEstudiante= function(){
        $scope.busy=true;
        $scope.estudiante={
            "idEstudiante":$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion,
            "idTipoDeIdentificacion":$scope.tipoDeIdentificacion,
            "numeroDeIdentificacion":$scope.numeroDeIdentificacion,
            "nombre":$scope.nombre,
            "codigo":$scope.codigo
        };
        estudiantes.update($scope.estudiante)
            .$promise.then(
            function(value){
                alert("La información del estudiante fue actualizada exitosamente");
                $location.path("Home");
                $scope.busy=false;
            },
            function(error){
                alert("Hubo un error al actualizar la información del estudiante");
                $scope.busy=false;
            }
        );
    };
}]);