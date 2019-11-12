'use strict';
angular.module('services.factory', ['ngRoute','ngResource'])
    .factory('admin', function($resource){
        return $resource('/admins/:idadmin',{idadmin:"@_idadmin"},{'get': { method: 'GET'}});
    })
    .factory('adminUsername', function($resource){
        return $resource('/admins/username/:username',{username:"@_username"},{'get': { method: 'GET'}});
    })
    .factory('admins', function($resource) {
        return $resource('/admins',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newAdmin', function($resource) {
        return $resource('/admins/new');
    })
    .factory('area', function($resource){
        return $resource('/areas/:idarea',{idarea:"@_idarea"},{'get': { method: 'GET'}});
    })
    .factory('areas', function($resource) {
        return $resource('/areas',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newArea', function($resource) {
        return $resource('/areas/new');
    })
    .factory('areaNombre', function($resource){
        return $resource('/areas/nombre/:nombre',{nombre:"@_nombre"},{'get': { method: 'GET'}});
    })
    .factory('asignatura', function($resource){
        return $resource('/asignaturas/:idasignatura',{idasignatura:"@_idasignatura"},{'get': { method: 'GET'}});
    })
    .factory('asignaturas', function($resource) {
        return $resource('/asignaturas',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newAsignatura', function($resource) {
        return $resource('/asignaturas/new');
    })
    .factory('asignaturaNombre', function($resource) {
        return $resource('/asignaturas/nombre/:idarea/:nombre',{idarea:"@_idarea"},{nombre:"@_nombre"},{'get': { method: 'GET'}});
    })
    .factory('asignaturaByArea', function($resource){
        return $resource('/asignaturas/area/:idarea',{idarea:"@_idarea"},{'get': { method: 'GET', isArray: true}});
    })
    .factory('calificacion', function($resource){
        return $resource('/calificaciones/:idcalificacion',{idcalificacion:"@_idcalificacion"},{'get': { method: 'GET'}});
    })
    .factory('calificaciones', function($resource) {
        return $resource('/calificaciones',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newCalificacion', function($resource) {
        return $resource('/calificaciones/new');
    })
    .factory('calificaiconByInforme', function($resource){
        return $resource('/calificaciones/informe/:idinforme',{idinforme:"@_idinforme"},{'get': { method: 'GET'}});
    })
    .factory('estudiante', function($resource){
        return $resource('/estudiantes/:idestudiante',{idestudiante:"@_idestudiante"},{'get': { method: 'GET'}});
    })
    .factory('estudiantes', function($resource) {
        return $resource('/estudiantes',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newEstudiante', function($resource) {
        return $resource('/estudiantes/new');
    })
    .factory('funcionario', function($resource){
        return $resource('/funcionarios/:idfuncionario',{idfuncionario:"@_idfuncionario"},{'get': { method: 'GET'}});
    })
    .factory('funcionarios', function($resource) {
        return $resource('/funcionarios',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newFuncionario', function($resource) {
        return $resource('/funcionarios/new');
    })
    .factory('informe', function($resource){
        return $resource('/informes/:idinforme',{idinforme:"@_idinforme"},{'get': { method: 'GET'}});
    })
    .factory('informes', function($resource) {
        return $resource('/informes',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newInforme', function($resource) {
        return $resource('/informes/new');
    })
    .factory('informeSpecific', function($resource){
        return $resource('/informes/:idestudiante/:anio/:curso',{idestudiante:"@_idestudiante"},{anio:"@_anio"},{curso:"@_curso"},{'get': { method: 'GET'}});
    })
    .factory('rol', function($resource){
        return $resource('/roles/:idrol',{idrol:"@_idrol"},{'get': { method: 'GET'}});
    })
    .factory('roles', function($resource) {
        return $resource('/roles',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newRol', function($resource) {
        return $resource('/roles/new');
    })
    .factory('tipodeidentificacion', function($resource){
        return $resource('/tiposdeidentificacion/:idtipodeidentificacion',{idtipodeidentificacion:"@_idtipodeidentificacion"},{'get': { method: 'GET'}});
    })
    .factory('tipodeidentificacionBySigla', function($resource){
        return $resource('/tiposdeidentificacion/sigla/:sigla',{sigla:"@_sigla"},{'get': { method: 'GET'}});
    })
    .factory('tiposdeidentificacion', function($resource) {
        return $resource('/tiposdeidentificacion',{},{ 'get': { method: 'GET', isArray: true}, 'update': { method: 'PUT', isArray: false}});
    })
    .factory('newTipodeidentificacion', function($resource) {
        return $resource('/tiposdeidentificacion/new');
    });