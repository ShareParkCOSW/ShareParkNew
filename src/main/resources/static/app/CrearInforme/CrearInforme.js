'use strict';

angular.module('myApp.CrearInforme', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CrearInforme', {
    templateUrl: 'CrearInforme/CrearInforme.html',
    controller: 'CrearInformeCtrl'
  });
}])

.controller('CrearInformeCtrl', ['$rootScope', '$scope', '$location', 'tiposdeidentificacion','funcionarios', 'estudiante','areas','asignaturaByArea',  function ($rootScope, $scope,$location,tiposdeidentificacion,funcionarios,estudiante,areas,asignaturaByArea) {

    $scope.tipoDeIdentificacion=null;
    $scope.tiposId=[];
    $scope.numeroDeIdentificacion=null;
    $scope.anio=null;
    $scope.curso=null;
    $scope.jornada=null;
    $scope.observaciones=null;
    $scope.directordecurso=null;
    $scope.directoresdecursoId=[];
    $scope.rector=null;
    $scope.rectoresId=[];
    $scope.secretario=null;
    $scope.secretariosId=[];
    $scope.showBasic=false;
    $scope.showCalificaciones=false;
    $scope.showRecuperaciones=false;
    $scope.calificaciones=[];
    $scope.recuperaciones=[];
    $scope.areasId=[];
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
    funcionarios.get()
        .$promise.then(
        //success
        function( value ){
            for(var i=0;i<value.length; i++){
                if(value[i].idRol==1){
                    $scope.rectoresId.push({"label":value[i].nombre,
                        "value":value[i].idFuncionario});
                }else if(value[i].idRol==2){
                    $scope.directoresdecursoId.push({"label":value[i].nombre,
                        "value":value[i].idFuncionario});
                }else if(value[i].idRol==3){
                    $scope.secretariosId.push({"label":value[i].nombre,
                        "value":value[i].idFuncionario});
                }
            }
        },
        //error
        function( error ){}
    );
    areas.get()
        .$promise.then(
        //success
        function (value) {
            for (var i = 0; i < value.length; i++) {
                $scope.areasId.push({
                    "label": value[i].nombre,
                    "value": value[i].idArea
                });
            }
        },
        //error
        function (error) {
        }
    );
    $scope.findEstudiante=function(){
        $scope.busy=true;
        estudiante.get({idestudiante:$scope.tipoDeIdentificacion+"-"+$scope.numeroDeIdentificacion})
            .$promise.then(
            //success
            function( value ){
                $scope.busy=false;
                $scope.showBasic=true;
            },
            //error
            function( error ){
                alert("No existe un estudiante con ese número de identificación");
                $scope.busy=false;
            }
        );
    }
    $scope.validateBasic= function(){
        $scope.showCalificaciones=true;
    };
    $scope.agregarRecuperaciones=function(){
      $scope.showRecuperaciones=true;
    };
    $scope.agregarCalficacion= function(){
        $scope.calificaciones.push({"idArea":"","idAsignatura":"","nota":"","asignaturasId":[],"recuperacion":false});
    };
    $scope.eliminarCalficacion= function(posicion){
        var calificacionesUpdate=[];
        for (var i = 0; i < $scope.calificaciones.length; i++) {
            if(i!=posicion){
                calificacionesUpdate.push($scope.calificaciones[i]);
            }
        }
        $scope.calificaciones=calificacionesUpdate;
    };
    $scope.eliminarRecuperacion= function(posicion){
        var recuperacionesUpdate=[];
        for (var i = 0; i < $scope.recuperaciones.length; i++) {
            if(i!=posicion){
                recuperacionesUpdate.push($scope.recuperaciones[i]);
            }
        }
        $scope.recuperaciones=recuperacionesUpdate;
    };
    $scope.agregarRecuperacion= function(){
        $scope.recuperaciones.push({"idArea":"","idAsigantura":"","nota":"","asignaturasId":[],"recuperacion":true,"fecha":""});
    };
    $scope.loadAsignaturas=function(posicion,idarea){
        asignaturaByArea.get({idarea:idarea})
            .$promise.then(
            //success
            function (value) {
                var asignaturas=[];
                for (var i = 0; i < value.length; i++) {
                    asignaturas.push({
                        "label": value[i].nombre,
                        "value": value[i].idAsignatura
                    });
                }
                $scope.calificaciones[posicion].asignaturasId=asignaturas;
            },
            //error
            function (error) {
                alert("No existen asignaturas para el área seleccionada");
            }
        );
    }
    $scope.loadAsignaturasRecuperacion=function(posicion,idarea){
        asignaturaByArea.get({idarea:idarea})
            .$promise.then(
            //success
            function (value) {
                var asignaturas=[];
                for (var i = 0; i < value.length; i++) {
                    asignaturas.push({
                        "label": value[i].nombre,
                        "value": value[i].idAsignatura
                    });
                }
                $scope.recuperaciones[posicion].asignaturasId=asignaturas;
            },
            //error
            function (error) {
                alert("No existen asignaturas para el área seleccionada");
            }
        );
    }
    $scope.save= function(){
        if(!$scope.formEstudiante.$valid){
            alert("La información del estudiante no es correcta");
        }
        if(!$scope.formInfo.$valid){
            alert("La información básica no es correcta");
        }
        if($scope.calificaciones.length==0){
            alert("Por favor agregue al menos una calificación al informe");
        }
        if(!$scope.validateCalificaciones()){
            alert("la información de las siguientes calificaciones no es correcta: "+$scope.erroresCalif);
        }
        if($scope.recuperaciones.length>=1 && !$scope.validateRecuperaciones()){
            alert("la información de las siguientes recuperaciones no es correcta: "+$scope.erroresCalif);
        }
    };
    $scope.erroresCalif="";
    $scope.validateCalificaciones=function () {
        var isValid=true;
        $scope.erroresCalif="";
        for (var i = 0; i < $scope.calificaciones.length; i++) {
            if(!$scope.calificaciones[i].idArea || !$scope.calificaciones[i].nota){
                isValid=false;
                $scope.erroresCalif+=i+1+" - ";
            }
        }
        return isValid;
    }
    $scope.validateRecuperaciones=function () {
        var isValid=true;
        $scope.erroresCalif="";
        for (var i = 0; i < $scope.recuperaciones.length; i++) {
            if(!$scope.recuperaciones[i].idArea || !$scope.recuperaciones[i].nota || !$scope.recuperaciones[i].fecha){
                isValid=false;
                $scope.erroresCalif+=i+1+" - ";
            }
        }
        return isValid;
    }
}]);