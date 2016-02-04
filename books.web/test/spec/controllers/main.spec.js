(function () {

    'use strict';

    var ptor = protractor.getInstance ? protractor.getInstance() : browser;

    //    var serviceMock = require('./mock/impl/xxxServicesMock');
    //    var mockData = require('./mock/data/xxxData');



    describe('[Basis] BooksApp', function () {

        it('soll die Übersichtsseite anzeigen.', function () {
            browser.get('/');
            expect(browser.getCurrentUrl()).toEqual('http://localhost:8000/#/');
        });

        it('soll ein Buch erfassen und dann in der Liste anzeigen.', function () {
            browser.get('/');
            element(by.id('titel')).sendKeys('Drachenhueter');
            element(by.id('newBookDataOK')).click();
            expect(element(by.id('titel#Drachenhueter')).isDisplayed()).toBe(true);
        });

    });
}());
