(function () {

    'use strict';

    /**
     * @ngdoc overview
     * @name bookswebApp
     * @description
     * # bookswebApp
     *
     * Main module of the application.
     */
    angular.module('BooksApp', [
        'BookListModule',
        'ngAnimate',
        'ngAria',
        'ngCookies',
        'ngMessages',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch'
    ]).controller('BooksAppController', function () {

    });
}());
