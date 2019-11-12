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
    $scope.closest=false;
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
            if(($scope.closest)&&($scope.getKilometros($scope.parkListAll[i].x, $scope.parkListAll[i].y, 2900))){
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
            }else if(!$scope.closest){
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
        }
    };

    /**
     * \fn getKilometros().
     * FUENTE: https://reviblog.net/2016/01/08/javascript-obtener-la-distancia-distancia-en-kilometros-entre-dos-puntos-dadas-por-su-latitud-y-longitud/
     * \Description: Devuelve la distancia en kilomegtros entre dos puntos dados por su latitud y longitud
     *
     * \param (integer) lat1 : Latitud del punto 1
     * \param (integer) long1 : Longitud del punto 1
     * \param (integer) lat2 : Latitud del punto 2
     * \param (integer) long2 : Longitud del punto 2
     *
     * \return (integer) Distancia en kilometros
     *
     **/

     $scope.userCoordinates=[20,20];

     $scope.getKilometros = function(lat2,lon2, dis)
     {
        var rad = function(x) {return x*Math.PI/180;}
        var R = 6378.137; //Radio de la tierra en km
         var dLat = rad( lat2 - $scope.userCoordinates[0] );
         var dLong = rad( lon2 - $scope.userCoordinates[1] );
        var a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(rad($scope.userCoordinates[0])) * Math.cos(rad(lat2)) * Math.sin(dLong/2) * Math.sin(dLong/2);
         var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
         var d = R * c;
        return d.toFixed(3)<=dis; //Retorna true si es cercano de acuerdo a la distancia parametro
     };
}]);