angular.module('BooksApp').factory('bookService', function ($http) {

    //POST http://localhost:8080/book/new
    var add = function (url, titel, isbn) {

        $http({
            method: 'POST',
            url: url,
            params: {
                'titel': titel,
                'isbn': isbn
            }
        }).then(function erfolg(response) {
            console.log(response);
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
        addBook: function (url, titel, isbn, refreshAction) {
            add(url, titel, isbn);
            refreshAction();
        },
        deleteBook: function (url, refreshAction) {
            del(url, refreshAction);
        }
    };

});