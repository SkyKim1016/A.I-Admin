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
.config(function ($stateProvider, $urlRouterProvider) {
        $stateProvider

            .state('signin', {
                url: '/signin',
                templateUrl: 'templates/signin.html',
                controller: 'SigninCtrl'
            })

            .state('main', {
                url: '/main',
                params: {condtionCognizeReq: {
                    pageNum: 1,
                    pageSize: 10
                }},
                templateUrl: 'templates/main.html',
                controller: 'MainCtrl',
                resolve: {
                    isAuth: function ($http, $state) {
                        // 백엔드에 인증여부를 확인하다.
                        return $http({method: 'GET', url: '/admin/auth'})
                            .error(function (data, status) {
                                // 인증되지 않은 경우 로그인 페이지로 이동.
                                $state.go('signin');
                            })
                    }
                }
            });

        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('/signin');
    })

    .run(function ($rootScope) {

    });