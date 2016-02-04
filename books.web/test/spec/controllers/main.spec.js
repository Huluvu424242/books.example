(function () {

    'use strict';

    var ptor = protractor.getInstance ? protractor.getInstance() : browser;

    //    var serviceMock = require('./mock/impl/jobSucheServicesMock');
    //    var mockData = require('./mock/data/jobsucheData');


    // example-spec.js
    describe('angularjs homepage', function () {

        it('should greet the named user', function () {
            browser.get('/');
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8000/#/');

            //        element(by.model('yourName')).sendKeys('Julie');
            //
            //        var greeting = element(by.binding('yourName'));
            //
            //        expect(greeting.getText()).toEqual('Hello Julie!');
        });
    });

}());
