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
        templateUrl: 'views/booklist.html',
        controller: 'BookController',
        controllerAs: 'bc'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
        redirectTo: '/'
      });
  })
   .controller('SiteController', [ '$http' ,function ($http) {
    // nix zu tun
  }]);

