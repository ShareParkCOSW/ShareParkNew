'use strict';

angular.module('myApp.viewCP', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewCP', {
    templateUrl: 'viewCP/viewCP.html',
    controller: 'ViewCPCtrl'
  });
}])

.controller('ViewCPCtrl', ['$scope','parkings', function($scope, parkings) {
    $scope.busy=true;
    $scope.onlyCovered=false;
    $scope.onlyHome=false;
    $scope.parkListFiltered=[];
    $scope.parkListAll=[];
    parkings.get()
    .$promise.then(
            //success
            function( value ){
                for(var i=0;i<value.length; i++){
                    if((value[i].home==true)||(value[i].home==false)){
                        $scope.parkListAll.push(value[i]);
                    }
                }
                $scope.parkListFiltered=$scope.parkListAll.slice(0);
                $scope.busy=false;
            },
            //error
            function( error ){

            }
    );
    $scope.filter=function(){
        $scope.parkListFiltered.length=0;
        $scope.both=false;
        for(var i=0;i<$scope.parkListAll.length; i++){
            $scope.both=($scope.onlyCovered)&&($scope.onlyHome);
            if(($scope.both)&&(($scope.parkListAll[i].covert)&&($scope.parkListAll[i].home))){
                $scope.parkListFiltered.push($scope.parkListAll[i]);
                $scope.both=true;
            }else if((!$scope.both)&&($scope.onlyCovered)&&($scope.parkListAll[i].covert)){
                $scope.parkListFiltered.push($scope.parkListAll[i]);
            }else if((!$scope.both)&&($scope.onlyHome)&&($scope.parkListAll[i].home)){
                $scope.parkListFiltered.push($scope.parkListAll[i]);
            }else if((!$scope.both)&&(!$scope.onlyCovered)&&(!$scope.onlyHome)){
                $scope.parkListFiltered.push($scope.parkListAll[i]);
            }
        }
    };
}]);