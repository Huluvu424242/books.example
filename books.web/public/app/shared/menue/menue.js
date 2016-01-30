(function () {
    'use strict';

    /* @ngInject */
    function menuedir() {

        function link(scope, element, attrs) {

        }

        var directive = {
            bindToController: false,
            templateUrl: 'app/shared/menue/menue.html',
            link: link,
            restrict: 'A',
            scope: {}
        };
        return directive;

    }

    menuedir.$inject = [];

    /*jslint white:true */
    /*global angular */
    angular
        .module('BooksApp')
        .directive('menue', menuedir);

}());
