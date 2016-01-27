/*
 * #%L
 * Books.App - Web
 * %%
 * Copyright (C) 2015 Pivotal Software, Inc.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
(function () {

    'use strict';

    angular.module('BooksApp')
        .controller('BookController', ['$http', function ($http) {
                var bc = this;
                bc.editModusAktiv = false;
                bc.books = [];

                //GET http://localhost:8080/books
                bc.refreshData = function (url) {

                    //default für allerersten Aufruf
                    if (typeof (bc.selfURL) === 'undefined') {
                        bc.selfURL = url;
                    }

                    bc.books = [];

                    $http.get(bc.selfURL).then(function erfolg(response) {

                        bc.baseURL = response.data._links.baseURL.href;
                        bc.selfURL = response.data._links.self.href;
                        bc.newURL = response.data.newURL;
                        bc.nextURL = response.data.nextURL;
                        bc.prevURL = response.data.prevURL;

                        response.data._embedded.bookList.forEach(function (book) {
                            bc.books.push(book);
                        });
                        // Ausblenden der Tabelle wenn keine Treffer
                        bc.ergebnisseVorhanden = (bc.books.length > 0);
                    }, function fehler(response) {
                        bc.message = response.statusText;
                    });
                };

                //POST http://localhost:8080/book/new
                bc.addBook = function () {

                    var titel = bc.newBookData.titel,
                        isbn = bc.newBookData.isbn;

                    $http({
                        method: 'POST',
                        //url : bc.newURL,
                        url: 'http://localhost:8080/book/new',
                        params: {
                            'titel': titel,
                            'isbn': isbn
                        }
                    }).then(function erfolg(response) {
                        bc.newBookData = {};
                        bc.refreshData();
                    }, function fehler(response) {
                        bc.message = "FEHLER BEIM ANGULAR ADD";
                    });
                };

                //DELETE http://localhost:8080/book/{id}
                bc.deleteBook = function (url) {

                    $http.delete(url).success(function (result) {
                        //console.log(result);
                        //document.getElementById(url).remove();
                        bc.refreshData();
                    }).error(function () {
                        console.log("FEHLER BEIM ANGULAR DELETE");
                    });
                };

                bc.refreshData('http://localhost:8080/books');
    }
  ]);
}());

// if ( typeof NS == 'undefined') {
// NS = {};
// }
//
// NS.myFunction = {
// //empty stuff array, filled during initialization
// stuff : [],
//
// init : function init() {
// this.stuff.push('Testing');
// },
// reset : function reset() {
// this.stuff = [];
// },
// //replace “//will add new functionality here later” with the following:
// append : function append(string1, string2) {
// return string1 + ' ' + string2;
// }
// };
//
// NS.myFunction.init();
