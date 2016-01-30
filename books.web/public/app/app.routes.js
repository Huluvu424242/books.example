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
    angular.module('BooksApp')
        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'app/components/book/uebersicht.html',
                    controller: 'BookController',
                    controllerAs: 'bc'
                })
                .when('/einstellungen', {
                    templateUrl: 'app/einstellungen.html',
                    controller: 'BooksAppController',
                    controllerAs: 'options'
                })
                .when('/impressum', {
                    templateUrl: 'app/impressum.html',
                    controller: 'BooksAppController',
                    controllerAs: 'impressum'
                })
                .when('/user', {
                    templateUrl: 'app/user.html',
                    controller: 'BooksAppController',
                    controllerAs: 'user'
                })
                //                .when('/about', {
                //                    templateUrl: 'app/about.html',
                //                    controller: 'DashboardController',
                //                    controllerAs: 'about'
                //                })
                .otherwise({
                    redirectTo: '/'
                });
        }]);

}());
