angular.module('starter.controllers', [])

    .controller('AppCtrl', function ($scope) {

    })

    .controller('SigninCtrl', function ($scope, $state, sha256, SigninService) {
        $scope.loginid = "";
        $scope.password = "";
        $scope.signin = function () {
            var signinReq = {
                loginid: $scope.loginid,
                password: sha256.convertToSHA256($scope.password)
            };
            SigninService.signin(signinReq)
                .then(function (data) {
                    alert(data);
                    $state.go('main');
                }, function (error) {
                    alert(error);
                });
        };
    })

    .controller('MainCtrl', function ($scope, $state, $stateParams, $uibModal, MainService) {
        var ws;

        $scope.condtionCognizeReq = $stateParams.condtionCognizeReq || {
                pageNum: 1,
                pageSize: 10
            };

        $scope.pageArr = [1];
        $scope.animationsEnabled = true;

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

        $scope.auth = function (callback) {
            MainService.auth()
                .then(function (user) {
                    if(!_.isNull(callback) && !_.isUndefined(callback) && _.isFunction(callback)) {
                        callback(user);
                    } else {
                        $state.go('main');
                    }
                }, function (error) {
                    console.log(error);
                    $state.go('signin');
                });
        };

        $scope.signout = function () {
            MainService.signout()
                .then(function (data) {
                    $state.go('signin');
                }, function (error) {
                    console.log(error);
                    $state.go('main');
                });
        };

        $scope.getConditionList = function (pageNum) {
            if(pageNum) {
                $scope.condtionCognizeReq.pageNum = pageNum;
            }
            MainService.getConditionList($scope.condtionCognizeReq)
                .then(function (data) {
                    $scope.pageInfo = data.pageInfo;
                    $scope.pageArr = makePageArr(data.pageInfo);
                    $scope.condtionCognizeList = data.list;
                }, function (error) {
                    console.log(error);
                });
        };

        $scope.auth($scope.getConditionList());

        $scope.modalOpen = function (conditionId) {
            $scope.auth(function(user) {
                var modalInstance = $uibModal.open({
                    animation: $scope.animationsEnabled,
                    templateUrl: 'myModalContent.html',
                    backdrop: 'static',
                    keyboard: false,
                    controller: function ($scope, $uibModalInstance, items, MainService) {
                        $scope.tags = [];

                        var getStuffInTags = function (tags) {
                            var stuffList = [];
                            if(!_.isNull(tags) && !_.isUndefined(tags) && !_.isEmpty(tags)) {
                                tags.forEach(function (tag) {
                                    stuffList.push(tag.text);
                                });
                            }
                            return stuffList;
                        };

                        $scope.getDetailCondition = function (conditionId, userId) {
                            MainService.getDetailCondition(conditionId, userId)
                                .then(function (data) {
                                    console.log(data);
                                    if(!_.isNull(data.cognize) || !_.isUndifined(data.cognize)) {
                                        if(!_.isEqual(data.cognize.viewStatus, "NONE")) {
                                            alert("다른 사람이 수정중입니다");
                                            $uibModalInstance.dismiss('cancel');
                                        } else {
                                            $scope.condition = data.cognize;
                                        }
                                    }
                                }, function (error) {
                                    alert(error);
                                });
                        };

                        $scope.modifyConfirm = function () {
                            var stuffList = getStuffInTags($scope.tags);
                            var req = {
                                id: conditionId,
                                userId: $scope.condition.userId,
                                stuffList: stuffList,
                                actionType: 'TRANSFER'
                            };
                            MainService.updateDetailCondition(conditionId, req)
                                .then(function (data) {
                                    $uibModalInstance.close();  
                                }, function (error) {
                                    alert(error);
                                })
                        };

                        $scope.modifyCancel = function () {
                            $uibModalInstance.dismiss('cancel');
                        };

                        $scope.getDetailCondition(conditionId, user.id);
                    },
                    size: 'lg',
                    resolve: {
                        items: function () {
                            return $scope.items;
                        }
                    }
                });

                modalInstance.result.then(function (selectedItem) {
                    $scope.selected = selectedItem;
                }, function () {
                    $log.info('Modal dismissed at: ' + new Date());
                });
            });
        };

        $scope.toggleAnimation = function () {
            $scope.animationsEnabled = !$scope.animationsEnabled;
        };

        $scope.getMainInfos = function () {
          
        };
    });
