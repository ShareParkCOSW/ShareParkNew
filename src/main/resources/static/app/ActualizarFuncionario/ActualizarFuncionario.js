'use strict';

angular.module('myApp.ActualizarFuncionario', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/ActualizarFuncionario', {
            templateUrl: 'ActualizarFuncionario/ActualizarFuncionario.html',
            controller: 'ActualizarFuncionarioCtrl'
        });
    }])

    .controller('ActualizarFuncionarioCtrl', ['$rootScope', '$scope', '$location', 'tiposdeidentificacion', 'roles', 'funcionario', 'funcionarios',   function ($rootScope, $scope,$location,tiposdeidentificacion,roles, funcionario, funcionarios) {

        $scope.showForm=false;
        $scope.tipoDeIdentificacion=null;
        $scope.tiposId=[];
        $scope.numeroDeIdentificacion=null;
        $scope.tipoDeIdentificacionFind=null;
        $scope.numeroDeIdentificacionFind=null;
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

        $scope.findFuncionario=function(){
            $scope.busy=true;
            funcionario.get({idfuncionario:$scope.tipoDeIdentificacionFind+"-"+$scope.numeroDeIdentificacionFind})
                .$promise.then(
                //success
                function( value ){
                    $scope.tipoDeIdentificacion=value.tipoDeIdentificacion;
                    $scope.numeroDeIdentificacion=value.numeroDeIdentificacion;
                    $scope.nombre=value.nombre;
                    $scope.idRol=value.idRol;
                    $scope.busy=false;
                    $scope.showForm=true;
                },
                //error
                function( error ){
                    alert("No existe un funcionario con ese número de identificación");
                    $scope.busy=false;
                }
            );
        }

        $scope.actualizarFuncionario= function(){
            $scope.busy=true;
            $scope.funcionario={
                "idFuncionario":$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion,
                "idTipoDeIdentificacion":$scope.tipoDeIdentificacion,
                "numeroDeIdentificacion":$scope.numeroDeIdentificacion,
                "nombre":$scope.nombre,
                "idRol":$scope.idRol
            };
            funcionarios.update($scope.funcionario)
                .$promise.then(
                function(value){
                    alert("La información del funcionario fue actualizada exitosamente");
                    $location.path("Home");
                    $scope.busy=false;
                },
                function(error){
                    alert("Hubo un error al actualizar la información del funcionario");
                    $scope.busy=false;
                }
            );
        };
    }]);