'use strict';

angular.module('myApp.ActualizarAsignatura', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ActualizarAsignatura', {
    templateUrl: 'ActualizarAsignatura/ActualizarAsignatura.html',
    controller: 'ActualizarAsignaturaCtrl'
  });
}])

.controller('ActualizarAsignaturaCtrl', ['$rootScope', '$scope', '$location', 'asignatura','asignaturas', 'areas','asignaturaByArea',  function ($rootScope, $scope,$location,asignatura,asignaturas, areas,asignaturaByArea) {

    $scope.showForm = false;
    $scope.areaIdFind = null;
    $scope.nombresAreasId = [];
    $scope.asignaturaIdFind = null;
    $scope.nombresasignaturasId = [];

    $scope.nombre = null;
    $scope.idArea = null;
    $scope.idAsignatura = null;
    $scope.intensidadHoraria = null;

    areas.get()
        .$promise.then(
        //success
        function (value) {
            for (var i = 0; i < value.length; i++) {
                $scope.nombresAreasId.push({
                    "label": value[i].nombre,
                    "value": value[i].idArea
                });
            }
        },
        //error
        function (error) {
        }
    );

    $scope.changeArea = function () {
        $scope.nombresasignaturasId=[];
        asignaturaByArea.get({idarea:$scope.areaIdFind})
            .$promise.then(
            //success
            function (value) {
                for (var i = 0; i < value.length; i++) {
                    $scope.nombresasignaturasId.push({
                        "label": value[i].nombre,
                        "value": value[i].idAsignatura
                    });
                }
            },
            //error
            function (error) {
                alert("No existen asignaturas para el área seleccionada");
            }
        );
    };

    $scope.findAsignatura=function(){
        $scope.busy=true;
        asignatura.get({idasignatura:$scope.asignaturaIdFind})
            .$promise.then(
            //success
            function( value ){
                $scope.nombre=value.nombre;
                $scope.intensidadHoraria=value.intensidadHoraria;
                $scope.idAsignatura=value.idAsignatura;
                $scope.idArea=value.idArea;
                $scope.busy=false;
                $scope.showForm=true;
            },
            //error
            function( error ){
                alert("No existe una asignatura con ese nombre");
                $scope.busy=false;
            }
        );
    }

    $scope.actualizarAsignatura= function(){
        $scope.busy=true;
        $scope.asignatura={
            "nombre":$scope.nombre,
            "intensidadHoraria":$scope.intensidadHoraria,
            "idAsignatura":$scope.idAsignatura,
            "idArea":$scope.idArea
        };
        asignaturas.update($scope.asignatura)
            .$promise.then(
            function(value){
                alert("La información de la asignatura fue actualizada exitosamente");
                $location.path("Home");
                $scope.busy=false;
            },
            function(error){
                alert("Hubo un error al actualizar la información de la asignatura");
                $scope.busy=false;
            }
        );
    };
}]);