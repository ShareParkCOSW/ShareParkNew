'use strict';
angular.module('services.parking', ['ngRoute','ngResource'])

  /*.factory('service1', function () {
        var data = {
            listado: []
        };
        return {
            getListado: function () {
                return data.listado;
            },
            addTodo: function (todo) {
                data.listado.push(todo);
            }};
    })*/
    .factory('getParkings', function($resource) {

        return $resource('/getParkings',{},
        { get: { method: 'GET', isArray: true}});
    });

