'use strict';

angular.module('myApp.TemplateHome', ['ngRoute'])

.controller('TemplateHomeCtrl', ['$rootScope', '$scope', '$location', function ($rootScope, $scope,$location) {

    $scope.goHome=function(){
        $location.path("Home");
    };
    $scope.goConsultarInforme=function(){
        $location.path("Home");
    };
    $scope.goCrearInforme=function(){
        $location.path("CrearInforme");
    };
    $scope.goCrearEstudiante=function(){
        $location.path("CrearEstudiante");
    };
    $scope.goActualizarEstudiante=function(){
        $location.path("ActualizarEstudiante");
    };
    $scope.goCrearFuncionario=function(){
        $location.path("CrearFuncionario");
    };
    $scope.goActualizarFuncionario=function(){
        $location.path("ActualizarFuncionario");
    };
    $scope.goCrearArea=function(){
        $location.path("CrearArea");
    };
    $scope.goActualizarArea=function(){
        $location.path("ActualizarArea");
    };
    $scope.goCrearAsignatura=function(){
        $location.path("CrearAsignatura");
    };
    $scope.goActualizarAsignatura=function(){
        $location.path("ActualizarAsignatura");
    };
    $scope.goCrearTipoId=function(){
        $location.path("CrearTipodeidentificacion");
    };
    $scope.goActualizarTipoId=function () {
        $location.path("ActualizarTipodeidentificacion");
    };
    $scope.goPerfil=function () {
        $location.path("ActualizarAdmin");
    };
    $scope.goLogout=function () {
        $rootScope.idAdminGlobal=null;
        $location.path("loginView");
    };
}]);