/**
 * Created by clauzewitz on 2016. 1. 28..
 */
var URL_BASE = "http://130.211.17.204:8080/recipe/rapi";
URL_BASE = "http://localhost:8080/recipe/rapi";

angular.module('starter.services', [])

    .service('MainService', function ($http, $q) {
        this.getSampleList = function (sampleReq) {
            var dfd = $q.defer();
            var url = URL_BASE + "/user/list";
            $http.post(url, sampleReq)
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
    });
