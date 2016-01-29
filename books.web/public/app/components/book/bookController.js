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
        .controller('BookController', ['$http', 'bookService', function ($http, bookService) {
            var bc = this;
            bc.editModusAktiv = false;
            bc.books = [];

            bc.refreshData = function () {

                //default für allerersten Aufruf
                if (typeof (bc.selfURL) === 'undefined') {
                    bc.selfURL = 'http://localhost:8080/books';
                }

                bookService.listBooks(bc.selfURL, function erfolg(books, links) {

                    bc.books = books;
                    // Ausblenden der Tabelle wenn keine Treffer
                    bc.ergebnisseVorhanden = (bc.books.length > 0);
                    // link liste
                    bc.baseURL = links.baseURL.href;
                    bc.selfURL = links.self.href;
                    bc.newURL = links.newURL.href;
                    bc.nextURL = links.nextURL.href;
                    bc.prevURL = links.prevURL.href;

                }, function fehler(statusText) {
                    bc.message = statusText;
                });
            };

            bc.addBook = function () {
                var titel = bc.newBookData.titel,
                    isbn = bc.newBookData.isbn;
                bookService.addBook('http://localhost:8080/book/new', titel, isbn, function () {
                    bc.newBookData = {};
                    bc.refreshData();
                });
            };

            bc.deleteBook = function (url) {
                bookService.deleteBook(url, bc.refreshData);
            };

            bc.refreshData();

        }]);
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
