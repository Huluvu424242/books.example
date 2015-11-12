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

var app = angular.module('BooksApp', [ 'ngTouch', 'ui.grid', 'ui.grid.cellNav',
		'ui.grid.edit', 'ui.grid.resizeColumns', 'ui.grid.pinning',
		'ui.grid.selection', 'ui.grid.moveColumns', 'ui.grid.exporter',
		'ui.grid.importer', 'ui.grid.grouping' ]);

app.controller('BookController',  ['$scope', '$http', '$timeout', '$interval', 'uiGridConstants', 'uiGridGroupingConstants',
function ($scope, $http, $timeout, $interval, uiGridConstants, uiGridGroupingConstants) {
    
	$scope.editModusAktiv=false;
	$scope.books = [];
	
//    $scope.gridOptions = {};
//    $scope.gridOptions.data = 'myData';
//    $scope.gridOptions.enableColumnResizing = true;
//    $scope.gridOptions.enableFiltering = true;
//    $scope.gridOptions.enableGridMenu = true;
//    $scope.gridOptions.showGridFooter = true;
//    $scope.gridOptions.showColumnFooter = true;
//    $scope.gridOptions.fastWatch = true;
    // $scope.gridOptions.minRowsToShow = 5;
   
//    $scope.gridOptions.rowIdentity = function(row) {
//      return row.id;
//    };
//    $scope.gridOptions.getRowIdentity = function(row) {
//      return row.id;
//    };
//   
//    $scope.gridOptions.columnDefs = [
//      { field:'id', displayName:'ID',  width:'10%' },
//      { field:'titel', name:'Titel', width:'40%', enableCellEdit: true},
//      { field:'isbn.formattedValue',displayName:'ISBN', width:'40%', enableCellEdit: true},
//      { field:'isbn.valid',displayName:'Check', width:'10%', enableCellEdit: false, type:'boolean'}
//    ];
//   
	
    //GET http://localhost:8080/books
    $scope.refreshData = function(defaultURL){
    	
    	//default für allerersten Aufruf
    	if (typeof($scope.selfURL)==='undefined') $scope.selfURL = defaultURL;
    	
        $scope.books = [];
    
        $http.get($scope.selfURL)
        .then(
			  function erfolg(response) {
				  
				  $scope.baseURL=response.data.baseURL;
				  $scope.selfURL=response.data.selfURL;
				  $scope.newURL=response.data.newURL;
				  $scope.nextURL=response.data.nextURL;
				  $scope.prevURL=response.data.prevURL;
				  
		        response.data.resources.forEach(function(book){
		          $scope.books.push(book);
		        });
			    // Ausblenden der Tabelle wenn keine Treffer
		        $scope.ergebnisseVorhanden=($scope.books.length > 0);
			  },
			  function fehler(response) {
			       $scope.message = response.statusText;
			  }
	      );
    };
    
    //POST http://localhost:8080/book/new
    $scope.addBook = function(){
    	
    	var titel = $scope.newBookData.titel;
    	var isbn  = $scope.newBookData.isbn;
        
	    $http({
	    	method: 'POST',
	    	url: $scope.newURL,
	    	params: {'titel': titel, 'isbn': isbn }
	    }).then( 
	          function erfolg (response){
	        	  $scope.newBookData={};
	        	  $scope.refreshData();
	          },
		      function fehler ( response ){
		    	  $scope.message ="FEHLER BEIM ANGULAR ADD";
		      }
		);
	};
    
	//DELETE http://localhost:8080/book/{id}
    $scope.deleteBook = function(url,index){
        
	      $http.delete(url)
	      .success( function(result){
	    	  //console.log(result);
	    	 //document.getElementById(url).remove();
	    	  $scope.refreshData();
	      })
	      .error( function(){
	    	  console.log("FEHLER BEIM ANGULAR DELETE");
	      });
	};
	
  }]);