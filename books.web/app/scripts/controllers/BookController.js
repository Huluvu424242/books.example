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
'use strict';
angular.module('BooksApp')
.controller('BookController', ['bc', '$http', '$timeout', '$interval', 'uiGridConstants', 'uiGridGroupingConstants',
function($http, $timeout, $interval, uiGridConstants, uiGridGroupingConstants) {

	var bc = this;

	bc.editModusAktiv = false;
	bc.books = [];

	//    bc.gridOptions = {};
	//    bc.gridOptions.data = 'myData';
	//    bc.gridOptions.enableColumnResizing = true;
	//    bc.gridOptions.enableFiltering = true;
	//    bc.gridOptions.enableGridMenu = true;
	//    bc.gridOptions.showGridFooter = true;
	//    bc.gridOptions.showColumnFooter = true;
	//    bc.gridOptions.fastWatch = true;
	// bc.gridOptions.minRowsToShow = 5;

	//    bc.gridOptions.rowIdentity = function(row) {
	//      return row.id;
	//    };
	//    bc.gridOptions.getRowIdentity = function(row) {
	//      return row.id;
	//    };
	//
	//    bc.gridOptions.columnDefs = [
	//      { field:'id', displayName:'ID',  width:'10%' },
	//      { field:'titel', name:'Titel', width:'40%', enableCellEdit: true},
	//      { field:'isbn.formattedValue',displayName:'ISBN', width:'40%', enableCellEdit: true},
	//      { field:'isbn.valid',displayName:'Check', width:'10%', enableCellEdit: false, type:'boolean'}
	//    ];
	//

	//GET http://localhost:8080/books
	bc.refreshData = function(defaultURL) {

		//default für allerersten Aufruf
		if ( typeof (bc.selfURL) === 'undefined')
			bc.selfURL = defaultURL;

		bc.books = [];

		$http.get(bc.selfURL).then(function erfolg(response) {

			bc.baseURL = response.data.baseURL;
			bc.selfURL = response.data.selfURL;
			bc.newURL = response.data.newURL;
			bc.nextURL = response.data.nextURL;
			bc.prevURL = response.data.prevURL;

			response.data.resources.forEach(function(book) {
				bc.books.push(book);
			});
			// Ausblenden der Tabelle wenn keine Treffer
			bc.ergebnisseVorhanden = (bc.books.length > 0);
		}, function fehler(response) {
			bc.message = response.statusText;
		});
	};

	//POST http://localhost:8080/book/new
	bc.addBook = function() {

		var titel = bc.newBookData.titel;
		var isbn = bc.newBookData.isbn;

		$http({
			method : 'POST',
			url : bc.newURL,
			params : {
				'titel' : titel,
				'isbn' : isbn
			}
		}).then(function erfolg(response) {
			bc.newBookData = {};
			bc.refreshData();
		}, function fehler(response) {
			bc.message = "FEHLER BEIM ANGULAR ADD";
		});
	};

	//DELETE http://localhost:8080/book/{id}
	bc.deleteBook = function(url, index) {

		$http.delete(url).success(function(result) {
			//console.log(result);
			//document.getElementById(url).remove();
			bc.refreshData();
		}).error(function() {
			console.log("FEHLER BEIM ANGULAR DELETE");
		});
	};

}]);

if ( typeof NS == 'undefined') {
	NS = {};
}

NS.myFunction = {
	//empty stuff array, filled during initialization
	stuff : [],

	init : function init() {
		this.stuff.push('Testing');
	},
	reset : function reset() {
		this.stuff = [];
	},
	//replace “//will add new functionality here later” with the following:
	append : function append(string1, string2) {
		return string1 + ' ' + string2;
	}
};

NS.myFunction.init(); 