angular.module('starter.controllers', [])

    .controller('AppCtrl', function ($scope) {

    })

    .controller('MainCtrl', function ($scope, $state, $stateParams, $uibModal, MainService) {
        $scope.sampleReq = $stateParams.sampleReq || {
                pageNum: 1,
                pageSize: 10
            };

        $scope.pageArr = [1];

        var calcPageNum = function (type, currentPage, lastPageNum, pageSize) {
            var pageNum = 0;
            type = type || 'start';
            switch (type) {
                case 'start' :
                    pageNum = Math.round(currentPage / pageSize) * pageSize;
                    break;
                default :
                    pageNum = Math.ceil(currentPage / pageSize) * pageSize;
                    if(pageNum > lastPageNum) {
                        pageNum = lastPageNum;
                    }
                    break;
            }
            return pageNum;
        }

        var makePageArr = function (pageInfo) {
            var pageArr = [];
            var startPage = calcPageNum('start', pageInfo.currentPageNum, pageInfo.lastPageNum, pageInfo.pageSize);
            var endPage = calcPageNum('end', pageInfo.currentPageNum, pageInfo.lastPageNum, pageInfo.pageSize);
            for (var i = startPage; i < endPage; i++) {
                pageArr.push(i + 1);
            }
            return pageArr;
        };

        $scope.getSampleList = function (pageNum) {
            if(pageNum) {
                $scope.sampleReq.pageNum = pageNum;
            }
            MainService.getSampleList($scope.sampleReq)
                .then(function (data) {
                    //$scope.sampleList = data.list;
                    $scope.makePageArr(data.pageInfo);
                    $scope.pageInfo = data.pageInfo;
                }, function (error) {
                    console.log(error);
                });
        };
        $scope.getSampleList();
    });
