(function () {

    'use strict';

    angular.module('BooksApp').factory('bookService', ['$http', function ($http) {

        //GET http://localhost:8080/books
        var list = function (url, erfolg, fehler) {

            $http.get(url).then(function success(response) {

                var books = [];
                response.data._embedded.bookList.forEach(function (book) {
                    books.push(book);
                });
                erfolg(books, response.data._links)
            }, function error(response) {
                fehler(response.statusText);
            });
        };

        //POST http://localhost:8080/book/new
        var add = function (url, titel, isbn, doAction) {

            $http({
                method: 'POST',
                url: url,
                params: {
                    'titel': titel,
                    'isbn': isbn
                }
            }).then(function erfolg(response) {
                console.log(response);
                doAction();
            }, function fehler(response) {
                control.message = "FEHLER BEIM ANGULAR ADD";
            });
        };


        //DELETE http://localhost:8080/book/{id}
        var del = function (url, doAction) {

            $http.delete(url).success(function (result) {
                doAction();
            }).error(function () {
                console.log("FEHLER BEIM ANGULAR DELETE");
            });
        };

        // public API
        return {
            listBooks: function (url, erfolg, fehler) {
                list(url, erfolg, fehler);
            },
            addBook: function (url, titel, isbn, refreshAction) {
                add(url, titel, isbn, refreshAction);
            },
            deleteBook: function (url, refreshAction) {
                del(url, refreshAction);
            }
        };

    }]);
}());
