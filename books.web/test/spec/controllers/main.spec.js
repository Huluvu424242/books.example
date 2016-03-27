(function () {

    'use strict';

    /*global browser,require, describe,it,expect */

    //var ptor = protractor.getInstance ? protractor.getInstance() : browser;

    var ptor = require('protractor'),
        by = ptor.By,
        element = browser.element;

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
            expect(element(by.id('titel#0')).isDisplayed()).toBe(true);
            expect(element(by.id('titel#0')).getInnerHtml()).toEqual('Drachenhueter');
        });

        it('soll ein Buch erfassen in der Liste anzeigen und wieder loeschen.', function () {
            browser.get('/');
            element(by.id('titel')).sendKeys('Drachenhueter');
            element(by.id('newBookDataOK')).click().then(function () {
                browser.sleep(5000);
                expect(element(by.id('titel#0')).isDisplayed()).toBe(true);
                expect(element(by.id('titel#0')).getInnerHtml()).toEqual('Drachenhueter');
                var idZeile2 = element(by.id('id#1')).getInnerHtml();
                browser.sleep(5000);
                element(by.id('deleteBook#0')).click().then(function () {
                    browser.sleep(5000);
                    expect(element(by.id('id#0')).getInnerHtml()).toEqual(idZeile2);
                    //browser.pause();
                });

            });
        });

    });

}());
