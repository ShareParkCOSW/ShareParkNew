'use strict';

angular.module('myApp.Register', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/Register', {
        templateUrl: 'Register/Register.html',
        controller: 'RegisterCtrl'
    });
}])

.controller('RegisterCtrl', ['admin','adminUsername', 'newAdmin', '$rootScope', '$scope','$http','$resource', '$location','tiposdeidentificacion', function (admin,adminUsername, newAdmin, $rootScope, $scope,$http,$resource, $location,tiposdeidentificacion) {

        $scope.tipoDeIdentificacion=null;
        $scope.tiposId=[];
        $scope.numeroDeIdentificacion=null;
        $scope.nombre=null;
        $scope.nombreDeUsuario=null;
        $scope.Contrasena=null;

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
            $rootScope.admin={
                "idAdmin":$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion,
                "idTipoDeIdentificacion":$scope.tipoDeIdentificacion,
                "numeroDeIdentificacion":$scope.numeroDeIdentificacion,
                "nombre":$scope.nombre,
                "userName":$scope.nombreDeUsuario,
                "password":$scope.Contrasena
            };
            admin.get({idadmin:$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion})
                .$promise.then(
                //success
                function( value ){
                    alert("Ya existe un usuario registrado para los datos de identificación dados");
                    $scope.busy=false;
                },
                //error
                function( error ){
                    adminUsername.get({username:""+$scope.nombreDeUsuario})
                        .$promise.then(
                        //success
                        function( value ){
                            alert("Ya existe el nombre de usuario dado, por favor ingresar uno diferente");
                            $scope.busy=false;
                        },
                        //error
                        function( error ){
                            newAdmin.save($rootScope.admin)
                                .$promise.then(
                                function(value){
                                    alert("Nuevo usuario creado exitosamente");
                                    $location.path("loginView");
                                    $scope.busy=false;
                                },
                                function(error){
                                    alert("El usuario no fue guardado");
                                    $scope.busy=false;
                                }
                            );
                        }
                    );
                }
            );
        };

        $scope.goLogin=function () {
            $location.path("loginView");
        }
}]);