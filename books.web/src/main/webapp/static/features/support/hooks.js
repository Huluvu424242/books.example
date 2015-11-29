

var myHooks = function() {

//    var fs = require('fs');
//    var encoder = require('base64-js').fromByteArray;
//    var decoder = require('base64-js').toByteArray;
    
    this.Before(function(scenario) {
        console.log("BEFORE SCENARIO:" + scenario.isFailed());
        // Just like inside step definitions, "this" is set to a World instance.
        // It's actually the same instance the current scenario step definitions
        // will receive.

        // Let's say we have a bunch of "maintenance" methods available on our
        // World
        // instance, we can fire some to prepare the application for the next
        // scenario:

        // this.bootFullTextSearchServer();
        // this.createSomeUsers();
    });

    this.After(function(scenario, callback) {

        console.log("AFTER SCENARIO:" + scenario.isFailed());

//        if (scenario.isFailed()) {
//            
//            browser.takeScreenshot().then(function(png) {
//                scenario.attach(new Buffer(png, 'base64'), 'image/png'); 
//            });
//        }

    });

};

module.exports = myHooks;