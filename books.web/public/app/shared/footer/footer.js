(function () {

    'use strict';

    /* @ngInject */
    function footerdir() {

        function main(scope, element, attrs) {

        }

        var directive = {
            bindToController: false,
            templateUrl: 'app/shared/footer/footer.html',
            link: main,
            restrict: 'A',
            scope: {}
        };
        return directive;

    }

    /*jslint white:true */
    /*global angular */
    angular
        .module('BooksApp')
        .directive('footer', footerdir);

    footerdir.$inject = [];

}());
