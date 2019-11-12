'use strict';

angular.module('myApp.CrearAsignatura', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CrearAsignatura', {
    templateUrl: 'CrearAsignatura/CrearAsignatura.html',
    controller: 'CrearAsignaturaCtrl'
  });
}])

.controller('CrearAsignaturaCtrl', ['$rootScope', '$scope', '$location', 'asignaturaNombre', 'newAsignatura','areas',  function ($rootScope, $scope,$location,asignaturaNombre, newAsignatura,areas) {

    $scope.nombre=null;
    $scope.intensidadHoraria=null;
    $scope.idArea=null;
    $scope.areasId=[];

    areas.get()
        .$promise.then(
        //success
        function( value ){
            for(var i=0;i<value.length; i++){
                $scope.areasId.push({"label":value[i].nombre,
                    "value":value[i].idArea});
            }
        },
        //error
        function( error ){}
    );

    $scope.save= function(){
        $scope.busy=true;
        $scope.asignatura={
            "nombre":$scope.nombre,
            "intensidadHoraria":$scope.intensidadHoraria,
            "idArea":$scope.idArea
        };
        asignaturaNombre.get({idarea:$scope.idArea},{nombre:$scope.nombre})
            .$promise.then(
            //success
            function( value ){
                alert("Ya existe una asignatura con ese nombre en esa área");
                $scope.busy=false;
            },
            //error
            function( error ){
                newAsignatura.save($scope.asignatura)
                    .$promise.then(
                    function(value){
                        alert("Nueva asignatura creada exitosamente");
                        $location.path("Home");
                        $scope.busy=false;
                    },
                    function(error){
                        alert("La asignatura no fue guardada");
                        $scope.busy=false;
                    }
                );
            }
        );
    };
}]);