'use strict';

angular.module('myApp.ActualizarTipodeidentificacion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ActualizarTipodeidentificacion', {
    templateUrl: 'ActualizarTipodeidentificacion/ActualizarTipodeidentificacion.html',
    controller: 'ActualizarTipodeidentificacionCtrl'
  });
}])

.controller('ActualizarTipodeidentificacionCtrl', ['$rootScope', '$scope', '$location', 'tipodeidentificacion', 'tiposdeidentificacion',  function ($rootScope, $scope,$location,tipodeidentificacion, tiposdeidentificacion) {

    $scope.showForm=false;
    $scope.siglaIdFind=null;
    $scope.siglasId=[];

    $scope.sigla=null;
    $scope.descripcion=null;

    tiposdeidentificacion.get()
        .$promise.then(
        //success
        function( value ){
            for(var i=0;i<value.length; i++){
                $scope.siglasId.push({"label":value[i].sigla,
                    "value":value[i].idTipoDeIdentificacion});
            }
        },
        //error
        function( error ){}
    );

    $scope.findTipodeId=function(){
        $scope.busy=true;
        tipodeidentificacion.get({idtipodeidentificacion:$scope.siglaIdFind})
            .$promise.then(
            //success
            function( value ){
                $scope.sigla=value.sigla;
                $scope.descripcion=value.descripcion;
                $scope.idTipoDeIdentificacion=value.idTipoDeIdentificacion;
                $scope.busy=false;
                $scope.showForm=true;
            },
            //error
            function( error ){
                alert("No existe un tipo de identificación con ese nombre");
                $scope.busy=false;
            }
        );
    }

    $scope.actualizarTipodeid= function(){
        $scope.busy=true;
        $scope.tipoDeIdentificacion={
            "sigla":$scope.sigla,
            "descripcion":$scope.descripcion,
            "idTipoDeIdentificacion":$scope.idTipoDeIdentificacion
        };
        tiposdeidentificacion.update($scope.tipoDeIdentificacion)
            .$promise.then(
            function(value){
                alert("La información del tipo de identificación fue actualizada exitosamente");
                $location.path("Home");
                $scope.busy=false;
            },
            function(error){
                alert("Hubo un error al actualizar la información del tipo de identificación");
                $scope.busy=false;
            }
        );
    };
}]);