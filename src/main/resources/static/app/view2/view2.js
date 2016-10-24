'use strict';

angular.module('myApp.view2', ['ngRoute','ngResource'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope', '$rootScope','$http','$resource', 'user', function($scope, $rootScope,$http,$resource,user) {
        $scope.newUser=false;
        $scope.userId=null;
        $scope.FirstName="";
        $scope.LastName ="";
        $scope.email="";
        $scope.address="";
        $scope.phone=null;
        $scope.password="";
        $scope.userN={"firstName":null,"lastName":null,
                        "id":null, "email": null, "address":null, "phone":null,
                        "password":null};

        $scope.registrarUser = function(){
            /**
            user.get({iduser:""+$scope.userId}, function(data){
                $scope.userN=data;
                console.info($scope.userN);
            });
            */
            user.get({iduser:""+$scope.userId})
            .$promise.then(
                    //success
                    function( value ){
                        alert("Ya existe un usuario con ID: "+$scope.userId+"!!!");
                    },
                    //error
                    function( error ){
                        var newitem={"firstName":$scope.FirstName,"lastName":$scope.LastName,
                        "id":$scope.userId, "email": $scope.email, "address":$scope.address, "phone":$scope.phone,
                        "password": $scope.password};
                        user.save(newitem,function(){});
                        alert("El usuario con el ID: "+$scope.userId+" fue creado satisfactoriamente!!!");
                        $scope.userId=null;
                        $scope.FirstName="";
                        $scope.LastName ="";
                        $scope.email="";
                        $scope.address="";
                        $scope.phone=null;
                        $scope.password="";
                    }
            );
        };
}]);