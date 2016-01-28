'use strict';

/**
 * @ngdoc overview
 * @name bookswebApp
 * @description
 * # bookswebApp
 *
 * Main module of the application.
 */
angular
    .module('BooksApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'app/components/book/booklist.html',
                controller: 'BookController',
                controllerAs: 'bc'
            })
            .when('/einstellungen', {
                templateUrl: 'app/einstellungen.html',
                controller: 'DashboardController',
                controllerAs: 'options'
            })
            .when('/impressum', {
                templateUrl: 'app/impressum.html',
                controller: 'DashboardController',
                controllerAs: 'impressum'
            })
            .when('/user', {
                templateUrl: 'app/user.html',
                controller: 'DashboardController',
                controllerAs: 'user'
            })
            .when('/about', {
                templateUrl: 'app/about.html',
                controller: 'DashboardController',
                controllerAs: 'about'
            })
            .otherwise({
                redirectTo: '/'
            });
    })
    .controller('SiteController', ['$http', function ($http) {
        // nix zu tun
  }]);