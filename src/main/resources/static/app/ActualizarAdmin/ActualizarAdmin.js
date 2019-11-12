'use strict';

angular.module('myApp.ActualizarAdmin', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ActualizarAdmin', {
    templateUrl: 'ActualizarAdmin/ActualizarAdmin.html',
    controller: 'ActualizarAdminCtrl'
  });
}])

.controller('ActualizarAdminCtrl', ['$rootScope', '$scope', '$location', 'tiposdeidentificacion', 'admin', 'adminUsername','admins',  function ($rootScope, $scope,$location,tiposdeidentificacion,admin, adminUsername,admins) {

    $scope.tipoDeIdentificacion=null;
    $scope.tiposId=[];
    $scope.numeroDeIdentificacion=null;
    $scope.nombre=null;
    $scope.userName=null;
    $scope.password=null;

    $scope.oldtipoDeIdentificacion=null;
    $scope.oldnumeroDeIdentificacion=null;
    $scope.olduserName=null;

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

    admin.get({idadmin:$rootScope.idAdminGlobal})
        .$promise.then(
        //success
        function( value ){
            $scope.tipoDeIdentificacion=value.idTipoDeIdentificacion;
            $scope.numeroDeIdentificacion=value.numeroDeIdentificacion;
            $scope.nombre=value.nombre;
            $scope.userName=value.userName;
            $scope.password=value.password;
            $scope.busy=false;
            $scope.oldtipoDeIdentificacion=value.idTipoDeIdentificacion;
            $scope.oldnumeroDeIdentificacion=value.numeroDeIdentificacion;
            $scope.olduserName=value.userName;
        },
        //error
        function( error ){
            alert("Hubo un error");
            $scope.busy=false;
        }
    );

    $scope.actualizarAdmin= function(){
        $scope.busy=true;
        $scope.adminUpdate={
            "idAdmin":$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion,
            "idTipoDeIdentificacion":$scope.tipoDeIdentificacion,
            "numeroDeIdentificacion":$scope.numeroDeIdentificacion,
            "nombre":$scope.nombre,
            "userName":$scope.userName,
            "password":$scope.password
        };
        admin.get({idadmin:$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion})
            .$promise.then(
            //success
            function( value ){
                if($scope.tipoDeIdentificacion!=$scope.oldtipoDeIdentificacion || $scope.numeroDeIdentificacion!=$scope.oldnumeroDeIdentificacion){
                    alert("Ya existe un usuario registrado para los datos de identificación dados");
                }else{
                    adminUsername.get({username:""+$scope.userName})
                        .$promise.then(
                        //success
                        function( value ){
                            if($scope.userName!=$scope.olduserName){
                                alert("Ya existe el nombre de usuario dado, por favor ingresar uno diferente");
                            }else{
                                admins.update($scope.adminUpdate)
                                    .$promise.then(
                                    function(value){
                                        alert("Tú información fue actualizada exitosamente");
                                        $location.path("Home");
                                        $scope.busy=false;
                                    },
                                    function(error){
                                        alert("Hubo un error al actualizar la información");
                                        $scope.busy=false;
                                    }
                                );
                            }
                            $scope.busy=false;
                        },
                        //error
                        function( error ){
                            admins.update($scope.adminUpdate)
                                .$promise.then(
                                function(value){
                                    alert("Tú información fue actualizada exitosamente");
                                    $location.path("Home");
                                    $scope.busy=false;
                                },
                                function(error){
                                    alert("Hubo un error al actualizar la información");
                                    $scope.busy=false;
                                }
                            );
                        }
                    );
                }

                $scope.busy=false;
            },
            //error
            function( error ){
                adminUsername.get({username:""+$scope.userName})
                    .$promise.then(
                    //success
                    function( value ){
                        if($scope.userName!=$scope.olduserName){
                            alert("Ya existe el nombre de usuario dado, por favor ingresar uno diferente");
                        }else{
                            admins.update($scope.adminUpdate)
                                .$promise.then(
                                function(value){
                                    alert("Tú información fue actualizada exitosamente");
                                    $location.path("Home");
                                    $scope.busy=false;
                                },
                                function(error){
                                    alert("Hubo un error al actualizar la información");
                                    $scope.busy=false;
                                }
                            );
                        }
                        $scope.busy=false;
                    },
                    //error
                    function( error ){
                        admins.update($scope.adminUpdate)
                            .$promise.then(
                            function(value){
                                alert("Tú información fue actualizada exitosamente");
                                $location.path("Home");
                                $scope.busy=false;
                            },
                            function(error){
                                alert("Hubo un error al actualizar la información");
                                $scope.busy=false;
                            }
                        );
                    }
                );
            }
        );
    };
}]);