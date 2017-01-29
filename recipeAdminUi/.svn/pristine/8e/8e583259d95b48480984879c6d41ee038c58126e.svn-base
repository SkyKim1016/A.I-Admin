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
                    pageNum = Math.floor(currentPage / 10) + 1;
                    break;
                default :
                    pageNum = Math.floor(currentPage / 10) + 10;
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
            for (var i = startPage; i <= endPage; i++) {
                pageArr.push(i);
            }
            
          //Loading Image Clear Function
            closeWindowByMask();
            
            
            return pageArr;
        };

        $scope.getSampleList = function (pageNum) {
            if(pageNum) {
                $scope.sampleReq.pageNum = pageNum;
            }
            
            MainService.getSampleList($scope.sampleReq)
                .then(function (data) {
                	$scope.sampleList = data.list;
                		console.log("===========<Controller> $scope.sampleList==========");
                		console.log(data.list);
                	$scope.pageInfo = data.pageInfo;
                    $scope.pageArr = makePageArr(data.pageInfo);
     
                	//makePageArr(data.pageInfo);
                    //makePageArr({"itemSize":4,"pageSize":25,"currentPageNum":3,"lastPageNum":1,"pageDistance":10});
                   // $scope.pageInfo = {"itemSize":4,"pageSize":25,"currentPageNum":3,"lastPageNum":1,"pageDistance":10};
                }, function (error) {
                    console.log(error);
                });
        };
        $scope.getSampleList();
    });
