/**
 * Created by clauzewitz on 2016. 1. 28..
 */
var URL_BASE = "http://130.211.17.204:8080/recipe/rapi";

URL_BASE = "http://104.155.225.112:8080/recipe/rapi";

angular.module('starter.services', [])

    .service('SigninService', function ($http, $q) {
        this.signin = function (req) {
            var dfd = $q.defer();
            var url = "/admin/login";
            $http.post(url, req)
                .success(function (result) {
                    if (result.code == 0) {
                        dfd.resolve(result.message);
                    }
                })
                .error(function (data, status) {
                    dfd.reject(data.message);
                });
            return dfd.promise;
        };
    })

    .service('MainService', function ($http, $q) {
        this.auth = function () {
            var dfd = $q.defer();
            var url = "/admin/auth";
            $http.get(url)
                .success(function (result) {
                    if (result.code == 0) {
                        dfd.resolve(result.data.user);
                    }
                })
                .error(function (data, status) {
                    dfd.reject(data.message);
                });
            return dfd.promise;
        };

        this.signout = function () {
            var dfd = $q.defer();
            var url = "/admin/logout";
            $http.get(url)
                .success(function (result) {
                    if (result.code == 0) {
                        dfd.resolve(result.message);
                    }
                })
                .error(function (data, status) {
                    dfd.reject(data.message);
                });
            return dfd.promise;
        };

        this.getConditionList = function (condtionCognizeReq) {
            var dfd = $q.defer();
            var url = URL_BASE + "/cognize/condition/request";
            $http.post(url, condtionCognizeReq)
                .success(function (result) {
                    console.log(result);
                    if (result.code == 0) {
                        dfd.resolve(result.data);
                    } else {
                        dfd.reject(result.message);    
                    }
                })
                .error(function (data, status) {
                    console.log(data);
                    console.log(status);
                    dfd.reject(data.message);
                });
            return dfd.promise;
        };

        this.getDetailCondition = function (conditionId, userId) {
            var dfd = $q.defer();
            var url = URL_BASE + "/cognize/condition/request/detail/" + conditionId;
            $http.get(url, {
                    params: { userid: userId }
                })
                .success(function (result) {
                    if (result.code == 0) {
                        dfd.resolve(result.data);
                    }
                })
                .error(function (data, status) {
                    dfd.reject(data.message);
                });
            return dfd.promise;
        };

        this.updateDetailCondition = function (conditionId, req) {
            var dfd = $q.defer();
            var url = URL_BASE + "/cognize/condition/request/detail/" + conditionId;
            $http.put(url, req)
                .success(function (result) {
                    if (result.code == 0) {
                        dfd.resolve(result.data);
                    }
                })
                .error(function (data, status) {
                    dfd.reject(data.message);
                });
            return dfd.promise;
        };
    });
