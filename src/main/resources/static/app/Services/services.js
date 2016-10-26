'use strict';
angular.module('services.parking', ['ngRoute','ngResource'])
    .factory('parkings', function($resource) {
        return $resource('/parkings',{},
        { get: { method: 'GET', isArray: true}});
    });

