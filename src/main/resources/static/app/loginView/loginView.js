'use strict';

angular.module('myApp.loginView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/loginView', {
    templateUrl: 'loginView/loginView.html',
    controller: 'LoginViewCtrl'
  });
}])

.controller('LoginViewCtrl', ['$scope', '$rootScope','$http','$resource', 'adminUsername','$location', function($scope, $rootScope,$http,$resource,adminUsername,$location) {

    $scope.username="";
    $scope.password="";

    $scope.login = function(){
        $scope.busy=true;
        adminUsername.get({username:""+$scope.username})
            .$promise.then(
            //success
            function( value ){
                if(value.password==$scope.password){
                    $rootScope.idAdminGlobal=value.idAdmin;
                    $location.path("Home");
                }else{
                    alert("La contraseña no es correcta");
                }
                $scope.busy=false;
            },
            //error
            function( error ){
                alert("El nombre de usuario no se encuentra registrado");
                $scope.busy=false;
            }
        );
    };
    
    $scope.continueRegister= function () {
        $location.path("Register");
    }
}]);