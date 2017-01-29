/**
 * Created by clauzewitz on 2016. 2. 4..
 */

var ResultWithData = {
    code : 0,
    message : "success",
    data : Object
};

exports.successResult = function (message, data) {
    var resultWithData = ResultWithData;
    resultWithData.code = 0;
    resultWithData.message = message;
    resultWithData.data = data;
    return resultWithData;
};

exports.failureResult = function (message, data) {
    var resultWithData = ResultWithData;
    resultWithData.code = -1;
    resultWithData.message = message;
    resultWithData.data = data;
    return resultWithData;
};
