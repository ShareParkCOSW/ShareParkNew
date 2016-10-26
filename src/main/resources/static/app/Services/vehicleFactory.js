'use strict';
angular.module('services.vehicles', ['ngRoute','ngResource'])
    .factory('vehicles', function($resource) {
        return $resource('/vehiculos/:plate',{plate:"@_plate"},{'get': { method: 'GET'}});
    });

