/**
 * Created by clauzewitz on 2016. 1. 27..
 */

const express = require('express');
const xml2js = require("xml2js");
const _ = require('underscore');
var ResultWithData = require('../module/common/resultWithData');
const mailSender = require('../config/email');
const router = express.Router();

module.exports = function(passport) {
    router.get('/', function (req, res, next) {
        mailSender.sendMail({
            from: "sjkim@1thefull.com",
            to: "sjkim@1thefull.com",
            subject: "테스트용",
            text: "Hello world"
        }, function(error, info){
            if(error){
                return console.log(error);
            }
            console.log('Message sent: ' + info.response);
        });
        res.render('index', {title: "recipe Admin"});
    });

    router.get('/auth', function(req, res) {
        if(!req.isAuthenticated()) {
            return res.json(401, {code: -4, meesage: "user is not signed"});
        }
        var user = req.user;
        return res.json(200, {code: 0, meesage: "user is signed", data: {'user': user}});
    });

    router.post('/login', function (req, res, next) {
        //  패스포트 모듈로 인증 시도
        passport.authenticate('local', function (err, user, info) {
            var error = err || info;
            if (error) return res.json(401, error);
            if (!user) return res.json(404, {message: 'Something went wrong, please try again.'});

            // 인증된 유저 정보로 응답
            return req.login(user, function (err) {
                if (err) {
                    return res.render('error', {message: err.message});
                } else {
                    return res.json(200, {code: 0, message: "signin success", data: {'user': user}});
                }
            });
        })(req, res, next);
    });

    router.get('/logout', function (req, res) {
        req.logout();
        return res.json(200, {code: 0, meesage: "user is signout"});
    });

    return router;
};


function isUserAuthenticated(req, res, next) {
    if (req.isAuthenticated()) {
        return next();
    } else {
        res.redirect('/');
    }
}