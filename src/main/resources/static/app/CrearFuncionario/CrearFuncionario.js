'use strict';

angular.module('myApp.CrearFuncionario', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CrearFuncionario', {
    templateUrl: 'CrearFuncionario/CrearFuncionario.html',
    controller: 'CrearFuncionarioCtrl'
  });
}])

.controller('CrearFuncionarioCtrl', ['$rootScope', '$scope', '$location', 'tiposdeidentificacion', 'roles', 'funcionario', 'newFuncionario',  function ($rootScope, $scope,$location,tiposdeidentificacion,roles,funcionario, newFuncionario) {

    $scope.tipoDeIdentificacion=null;
    $scope.tiposId=[];
    $scope.numeroDeIdentificacion=null;
    $scope.nombre=null;
    $scope.idRol=null;
    $scope.rolesId=[];

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

    roles.get()
        .$promise.then(
        //success
        function( value ){
            for(var i=0;i<value.length; i++){
                $scope.rolesId.push({"label":value[i].cargo,
                    "value":value[i].idRol});
            }
        },
        //error
        function( error ){}
    );

    $scope.save= function(){
        $scope.busy=true;
        $scope.funcionario={
            "idFuncionario":$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion,
            "idTipoDeIdentificacion":$scope.tipoDeIdentificacion,
            "numeroDeIdentificacion":$scope.numeroDeIdentificacion,
            "nombre":$scope.nombre,
            "idRol":$scope.idRol
        };
        funcionario.get({idfuncionario:$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion})
            .$promise.then(
            //success
            function( value ){
                alert("Ya existe un funcionario registrado para los datos de identificación dados");
                $scope.busy=false;
            },
            //error
            function( error ){
                newFuncionario.save($scope.funcionario)
                    .$promise.then(
                    function(value){
                        alert("Nuevo funcionario creado exitosamente");
                        $location.path("Home");
                        $scope.busy=false;
                    },
                    function(error){
                        alert("El funcionario no fue guardado");
                        $scope.busy=false;
                    }
                );
            }
        );
    };
}]);