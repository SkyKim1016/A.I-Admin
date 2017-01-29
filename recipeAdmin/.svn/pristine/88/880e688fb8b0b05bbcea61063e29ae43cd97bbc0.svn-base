/**
 * Created by kimsungjun on 2016. 5. 11..
 */

const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const crypto = require('crypto');
const mysql = require('mysql');
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


// expose this function to our app using module.exports
module.exports = function() {
    // =========================================================================
    // passport session setup ==================================================
    // =========================================================================
    // required for persistent login sessions
    // passport needs ability to serialize and unserialize users out of session

    // used to serialize the user for the session
    passport.serializeUser(function(user, done) {
        done(null, user);
    });

    // used to deserialize the user
    passport.deserializeUser(function(user, done) {
        done(null, user);
    });

    passport.use('local', new LocalStrategy({
            usernameField: 'loginid',
            passwordField: 'password',
            passReqToCallback : true
        }, function (req, loginid, password, done) {
            var cipher = crypto.createCipher('aes192', 'rlatjdwnsWkd!');
            var encrypted = cipher.update(password, 'utf8', 'hex');
            encrypted += cipher.final('hex');
            console.log(encrypted);
            mysqlDB.query("SELECT id, userid, password FROM mst_user WHERE loginid = ? AND admin = 'Y'"
                , [loginid], function (err, user) {
                    if (err) {
                        throw err;
                    }
                    if (!user[0]) {
                        return done(null, false, {code: -2, message: 'Incorrect username.'});
                    }
                    if (user[0].password != encrypted) {
                        return done(null, false, {code: -3, message: 'Incorrect password.'});
                    }
                    delete user[0].password;
                    return done(null, user[0]);
                });
        }
    ));
    return passport;
}();