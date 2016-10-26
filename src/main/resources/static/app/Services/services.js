'use strict';
angular.module('services.parking', ['ngRoute','ngResource'])
    .factory('parkings', function($resource) {
        return $resource('/parkings',{},
        { get: { method: 'GET', isArray: true}});
    })
    .factory('parkingByAdd', function($resource){
        return $resource('/parkings/:idparking',{id:"@_idparking"},{'get': { method: 'GET'}});
    });

