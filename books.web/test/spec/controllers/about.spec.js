//(function () {
//
//    'use strict';
//
//    var ptor = protractor.getInstance ? protractor.getInstance() : browser;
//
//    //var serviceMock = require('./mock/impl/jobSucheServicesMock');
//    //var mockData = require('./mock/data/jobsucheData');
//
//    describe('Controller: BookController', function () {
//
//        // load the controller's module
//        beforeEach(module('BooksApp'));
//
//        var BookCtrl,
//            scope;
//
//        // Initialize the controller and a mock scope
//        beforeEach(inject(function ($controller, $rootScope) {
//            scope = $rootScope.$new();
//            BookCtrl = $controller('BookController', {
//                $scope: scope // place here mocked dependencies
//            });
//        }));
//
//        it('should attach a list of awesomeThings to the scope', function () {
//            expect(BookCtrl.awesomeThings.length).toBe(3);
//        });
//    });
//}());