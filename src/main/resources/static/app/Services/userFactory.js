'use strict';
angular.module('services.factory', ['ngRoute','ngResource'])
    .factory('user', function($resource){
        return $resource('/usuarios/:iduser',{id:"@_iduser"},{'get': { method: 'GET', isArray: true}});
    });
