/**
 * Created by kimsungjun on 2016. 5. 11..
 */

const express = require('express');
const request = require('request');
const mysql = require('mysql');
const xml2js = require("xml2js");
const cron = require('cron');
const apn = require('apn');
const gcm = require('node-gcm');
const _ = require('underscore');
var ResultWithData = require('../module/common/resultWithData');
const router = express.Router();
const app = express();
/*
 //Develop
 var APNS_DEV_SERVER_URL = "gateway.sandbox.push.apple.com";
 var APNS_DEV_CERT_FILE = "./keys/cert_dev.pem";
 var APNS_DEV_KEY_FILE = "./keys/key_dev.pem";
 */
 /*
 //Product
const APNS_SERVER_URL = "gateway.push.apple.com";
const APNS_CERT_FILE = "./keys/cert.pem";
const APNS_KEY_FILE = "./keys/key.pem";
*/
const GCM_SENDER = new gcm.Sender('AIzaSyDl_5K9n6wSvjumimzhPS9QHGLmQix-Auw');

const mysqlDB = mysql.createConnection({
    host: '104.155.225.112',
    port: 3306,
    user: 'root',
    password: '0412',
    database: 'recipe_proto'
});

mysqlDB.connect(function (err) {
    if (err) {
        console.error('error connecting: ' + err.stack);
        return;
    }
    console.log('connected as id ' + mysqlDB.threadId);
});

/* Schedulling to device remove */
new cron.CronJob('0 0 2 * * *', function () {
    /*
    var options = {
        gateway: APNS_SERVER_URL,
        cert: APNS_CERT_FILE,
        key: APNS_KEY_FILE,
        batchFeedback: true,
        interval: 300
    };

    var feedback = new apn.Feedback(options);
    feedback.on('feedback', function (devices) {
        devices.forEach(function (item) {
            var token = bintohex(item.device.token);
            Device.remove({'token': token.toLowerCase()}, function (error) {
                if (error) {
                    console.err(error);
                    throw error;
                }
            });
        });
    });
    */
}, null, true, "Asia/Seoul");

/* Schedulling to push */
new cron.CronJob('0 0 4-15 * * *', function () {
    /*
    var options = {
        gateway: APNS_SERVER_URL,
        cert: APNS_CERT_FILE,
        key: APNS_KEY_FILE
    };

    var apnConnection = new apn.Connection(options);

    var note = new apn.Notification();
    note.badge = 1;
    note.sound = "default";
    //note.payload = {'message': '안녕하세요'};

    note.alert = "테스트용";
    var myDevice = new apn.Device(device.token);
    apnConnection.pushNotification(note, myDevice);
    */
}, null, true, "Asia/Seoul");

/* GET root listing. */
router.get('/', function (req, res, next) {
    res.render('index', {title: "Push Service"});
});

/* Save device info. */
router.post('/send', function (req, res, next) {
    if (!req.body || !req.body['pushInfos']) {
        res.send(ResultWithData.failureResult("invalid parameter"));
        return false;
    }
    var pushInfos = req.body['pushInfos'];
    if(_.isNull(pushInfos.devices) || _.isUndefined(pushInfos.devices) || _.isEmpty(pushInfos.devices)) {
        return false;
    }
    var androidDeviceIds = [];
    var iosDeviceIds = [];
    pushInfos.devices.forEach(function (device) {
        switch (device.deviceType) {
            case 'ios' :
                iosDeviceIds.push(device.regid);
                break;
            default :
                androidDeviceIds.push(device.regid);
                break;
        }
    });
    var androidNoti = {
        pushType: pushInfos.pushType,
        title: pushInfos.title,
        message: pushInfos.message,
        param1: null,
        param2: null,
        deviceIds: androidDeviceIds
    }
    sendAndroidPush(androidNoti);
    var iosNoti = {
        pushType: pushInfos.pushType,
        title: pushInfos.title,
        message: pushInfos.message,
        param1: null,
        param2: null,
        deviceIds: iosDeviceIds
    }
    res.json(200);
    //sendIosPush(androidNoti);
});

/* Update device info. */
router.put('/device', function (req, res, next) {
    if (!req.body || !req.body['device']) {
        res.send(ResultWithData.failureResult("invalid parameter"));
        return false;
    }
    var device = req.body['device'];
    var query = {
        "token": device.token
    };
    Device.findOneAndUpdate(query, device, function (err, device) {
        if (err) {
            var resultWithData = ResultWithData.failureResult("DB Error");
            resultWithData.code = -2;
            res.send(resultWithData);
        }
        res.send(ResultWithData.successResult());
    });
});

router.get('/test', function(req, res) {
    // or with object values
    var d = new Date();
    var n = d.getMilliseconds(); 
    var message = new gcm.Message({
         collapseKey: n.toString(),
         delayWhileIdle: false,
         timeToLive: 3,
         data: {
              type: "notice",
              title: "제목입니다",
              message: "설명입니다",
              param1: '첫번째파람',
              param2: '두번째파람'
         }
    });
    
    var registrationIds = [ ];     // 여기에 pushid 문자열을 넣는다.

    registrationIds = ['APA91bElKFh9Kdrg5L8uHzlSUYoaORoYQfvrN6uZCQULCvE8xh6nUomI5fB9mzXH9sk7Ux1mhUvhM2f_98C0ojkNU-EzetTlBjcdVZRS3APY2gfI3DQSUGaWxAQGx2urVi7Zed8wfLBl'];
    //registrationIds = ['APA91bFARuumMMveNgmgVZ0qAr433vomgH1BLzDGwogL5g6773KIZ5Zp25ZIt8Y_POrljobFV1Owr7WpXBlu7KZN_0RT7EmLEZPLYZ11mYLJEauEZuYivHlbH_-yyl9DuMbSAaMUybP1'];

    /*
    for (var i=0; i<push_ids.length; i++) {
         registrationIds.push(push_ids[i]);
    }
    */

    // 푸시를 날린다!
    GCM_SENDER.send(message, registrationIds, 4, function (err, result) {
        if(err) {
            console.log(err);
            res.json(err.status);
        } else {
            console.log(result);
            res.json(200);
        }
         // 여기서 푸시 성공 및 실패한 결과를 준다. 재귀로 다시 푸시를 날려볼 수도 있다.
        //console.log(result);
    });
});

/* Parsing to device(iOS) token String. */
function bintohex(buf) {
    var hexbuf = new Buffer(buf.length * 2);

    function nibble(b) {
        if (b <= 0x09) return 0x30 + b;
        return 0x41 + (b - 10);
    }

    for (var i = 0; i < buf.length; i++) {
        hexbuf[i * 2] = nibble(buf[i] >> 4);
        hexbuf[i * 2 + 1] = nibble(buf[i] & 0x0F);
    }
    return hexbuf.toString('ascii', 0, hexbuf.length);
}

function sendAndroidPush(notice) {
    var d = new Date();
    var n = d.getMilliseconds(); 
    var message = new gcm.Message({
         collapseKey: n.toString(),
         delayWhileIdle: false,
         timeToLive: 3,
         data: {
              type: notice.pushType,
              title: notice.title,
              message: notice.message,
              param1: notice.param1,
              param2: notice.param2
         }
    });
    
    var registrationIds = [ ];     // 여기에 pushid 문자열을 넣는다.

    for (var i = 0; i < notice.deviceIds.length; i++) {
         registrationIds.push(notice.deviceIds[i]);
    }

    // 푸시를 날린다!
    GCM_SENDER.send(message, registrationIds, 4, function (err, result) {
         // 여기서 푸시 성공 및 실패한 결과를 준다. 재귀로 다시 푸시를 날려볼 수도 있다.
         console.log(result); 
    });
}

function sendIosPush(notice) {
    var options = {
        gateway: APNS_SERVER_URL,
        cert: APNS_CERT_FILE,
        key: APNS_KEY_FILE
    };

    var apnConnection = new apn.Connection(options);

    var note = new apn.Notification();
    note.badge = 1;
    note.sound = "default";
    note.payload = {
        'message': notice.message,
        'param1': notice.param1,
        'param2': notice.param2
    };
    note.alert = "테스트용";

    var myDevices = [];
    for (var i = 0; i < notice.deviceIds.length; i++) {
        var myDevice = new apn.Device(notice.deviceIds[i]);
        myDevices.push(myDevice);
    }
    apnConnection.pushNotification(note, myDevices);
}

module.exports = router;
