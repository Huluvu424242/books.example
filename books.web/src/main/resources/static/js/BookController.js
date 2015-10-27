
var app = angular.module('BooksApp', [ 'ngTouch', 'ui.grid', 'ui.grid.cellNav',
		'ui.grid.edit', 'ui.grid.resizeColumns', 'ui.grid.pinning',
		'ui.grid.selection', 'ui.grid.moveColumns', 'ui.grid.exporter',
		'ui.grid.importer', 'ui.grid.grouping' ]);

app.controller('BookController',  ['$scope', '$http', '$timeout', '$interval', 'uiGridConstants', 'uiGridGroupingConstants',
function ($scope, $http, $timeout, $interval, uiGridConstants, uiGridGroupingConstants) {
    
	$scope.myData = [];
	
    $scope.gridOptions = {};
    $scope.gridOptions.data = 'myData';
    $scope.gridOptions.enableColumnResizing = true;
    $scope.gridOptions.enableFiltering = true;
    $scope.gridOptions.enableGridMenu = true;
    $scope.gridOptions.showGridFooter = true;
    $scope.gridOptions.showColumnFooter = true;
    $scope.gridOptions.fastWatch = true;
    // $scope.gridOptions.minRowsToShow = 5;
   
    $scope.gridOptions.rowIdentity = function(row) {
      return row.id;
    };
    $scope.gridOptions.getRowIdentity = function(row) {
      return row.id;
    };
   
    $scope.gridOptions.columnDefs = [
      { field:'id', displayName:'ID',  width:'10%' },
      { field:'titel', name:'Titel', width:'40%', enableCellEdit: true},
      { field:'isbn.formattedValue',displayName:'ISBN', width:'40%', enableCellEdit: true},
      { field:'isbn.valid',displayName:'Check', width:'10%', enableCellEdit: false, type:'boolean'}
    ];
   
    $scope.refreshData = function(){
        $scope.myData = [];
    
        $http.get('http://localhost:8080/books/json')
        .then(
			  function erfolg(response) {
		        var i = 0;
		        response.data.forEach(function(row){
		          row.id = i;
		          i++;
		          $scope.myData.push(row);
		        });
			  },
			  function fehler(response) {
			       $scope.text = response.status;
			  }
	      );
    };
    
    
    $scope.deleteBook = function(id){
        
	      $http.delete('http://localhost:8080/book/delete/'+id)
	      .success( function(result){
	    	  console.log(result);
	    	  document.getElementById('book_'+id).remove();
	      })
	      .error( function(){
	    	  console.log("FEHLER BEIM ANGULAR DELETE");
	      });
	  };
       

  }]);