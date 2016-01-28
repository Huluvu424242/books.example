angular.module('BooksApp').factory('bookService', function ($http) {

    //POST http://localhost:8080/book/new
    var add = function (url, titel, isbn, control) {

        $http({
            method: 'POST',
            url: url,
            params: {
                'titel': titel,
                'isbn': isbn
            }
        }).then(function erfolg(response) {
            control.newBookData = {};
        }, function fehler(response) {
            control.message = "FEHLER BEIM ANGULAR ADD";
        });
    };

    // public API
    return {
        addBook: function (url, controller, titel, isbn) {
            add(url, titel, isbn, controller);
        }
    };

});