// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.controllers' is found in controllers.js
angular.module('underscore', [])
    .factory('_', function () {
        return window._; // assumes underscore has already been loaded on the page
    });

angular.module('jquery', [])
    .factory('$', function () {
        return window.$; // assumes underscore has already been loaded on the page
    });

angular.module('starter', [
        'ui.router',
        'ngResource',
        'ngSanitize',
        'ngAnimate',
        'ui.bootstrap',
        'ngTagsInput',
        'starter.controllers',
        'starter.services',
        'underscore',
        'jquery',
        'angular-encryption'
        //'ngWebsocket'
    ])
	/*.config([
	    "$httpProvider",
	    function($httpProvider){
	        $httpProvider.defaults.headers.common['Access-Control-Allow-Headers'] = '*';
	        $httpProvider.defaults.useXDomain = true;
	        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	    }
	])*/
    .run(function ($rootScope) {

    });