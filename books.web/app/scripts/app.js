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
    'ngTouch', 
    'ui.grid', 
    'ui.grid.cellNav', 
    'ui.grid.edit', 
    'ui.grid.resizeColumns', 
    'ui.grid.pinning', 
    'ui.grid.selection', 
    'ui.grid.moveColumns', 
    'ui.grid.exporter', 
    'ui.grid.importer', 
    'ui.grid.grouping'
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
  });
