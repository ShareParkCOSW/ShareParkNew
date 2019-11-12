'use strict';
angular.module('services.factory', ['ngRoute','ngResource'])
    .factory('parkings', function($resource) {
        return $resource('/parkings',{},
        { get: { method: 'GET', isArray: true}});
    })
    .factory('parkingByAdd', function($resource){
        return $resource('/parkings/:idparking',{id:"@_idparking"},{'get': { method: 'GET'}});
    })
    .factory('user', function($resource){
        return $resource('/usuarios/:iduser',{id:"@_iduser"},{'get': { method: 'GET'}});
    })
    .factory('vehicles', function($resource) {
        return $resource('/vehiculos/:plate',{plate:"@_plate"},{'get': { method: 'GET'}});
    })
    .factory('creditCardById', function($resource) {
        return $resource('/tarjetas/:cardNumber',{cardNumber:"@_cardNumber"},{'get': { method: 'GET'}});
    })
    .factory('creditCards', function($resource) {
        return $resource('/tarjetas',{'get': { method: 'GET'}});
    });


