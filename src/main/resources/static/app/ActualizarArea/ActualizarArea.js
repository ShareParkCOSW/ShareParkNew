'use strict';

angular.module('myApp.ActualizarArea', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ActualizarArea', {
    templateUrl: 'ActualizarArea/ActualizarArea.html',
    controller: 'ActualizarAreaCtrl'
  });
}])

.controller('ActualizarAreaCtrl', ['$rootScope', '$scope', '$location', 'area', 'areas',  function ($rootScope, $scope,$location,area, areas) {

    $scope.showForm=false;
    $scope.nombreFind=null;
    $scope.nombre=null;
    $scope.idArea=null;
    $scope.nombresId=[];
    $scope.intensidadHoraria=null;

    areas.get()
        .$promise.then(
        //success
        function( value ){
            for(var i=0;i<value.length; i++){
                $scope.nombresId.push({"label":value[i].nombre,
                    "value":value[i].idArea});
            }
        },
        //error
        function( error ){}
    );

    $scope.findArea=function(){
        $scope.busy=true;
        area.get({idarea:$scope.nombreFind})
            .$promise.then(
            //success
            function( value ){
                $scope.nombre=value.nombre;
                $scope.intensidadHoraria=value.intensidadHoraria;
                $scope.idArea=value.idArea;
                $scope.busy=false;
                $scope.showForm=true;
            },
            //error
            function( error ){
                alert("No existe un áre con ese nombre");
                $scope.busy=false;
            }
        );
    }

    $scope.actualizarArea= function(){
        $scope.busy=true;
        $scope.area={
            "nombre":$scope.nombre,
            "intensidadHoraria":$scope.intensidadHoraria,
            "idArea":$scope.idArea
        };
        areas.update($scope.area)
            .$promise.then(
            function(value){
                alert("La información del área fue actualizada exitosamente");
                $location.path("Home");
                $scope.busy=false;
            },
            function(error){
                alert("Hubo un error al actualizar la información del área");
                $scope.busy=false;
            }
        );
    };
}]);