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
            sPageNum = currentPage % pageSize; 
            pageNum = Math.floor(pageSize % currentPage) * Math.floor(currentPage / pageSize) + 1;
            console.log(sPageNum);
            if(sPageNum == 0) {
                if(pageNum > pageSize) {
                    pageNum = pageNum - pageSize;
                    console.log("pageNum : " + pageNum);
                }
            }
            if(type == 'end') {
                console.log(pageNum);
                if(pageNum <= pageSize) {
                    pageNum = pageSize;
                } else {
                    pageNum = (Math.floor(pageNum / pageSize) + 1) * pageSize;
                }
                //alert("defalut PageSize"+pageNum);
                if(pageNum > lastPageNum) {

                    pageNum = lastPageNum;
                }
            }
            return pageNum;
        }

        var makePageArr = function (pageInfo) {
        	console.log(pageInfo);
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

        /*$socpe.setSelected = function(){
            //#('#editModal').modal();
        };*/

        $scope.getSampleList = function (pageNum) {
            if(pageNum) {
                $scope.sampleReq.pageNum = pageNum;
               
            }
            
           /* alert("pageSize=" + pageSize);
            alert("pageNum=" + pageNum);
            
            console.log("pageSize=" + pageSize);
            console.log("pageNum=" + pageNum);*/
            
            
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
        }; //$scope.getSampleList End 
        $scope.getSampleList();
        
        
        $scope.getModalView = function (id) {
            MainService.getModalView(id)
                .then(function (data) {
                    console.log(data);
            
                }, function (error) {
                    alert(error);
                });
        };
        
    }) // Controller End 
    