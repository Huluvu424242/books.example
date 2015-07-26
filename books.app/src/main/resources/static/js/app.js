    var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.cellNav', 'ui.grid.edit', 'ui.grid.resizeColumns', 'ui.grid.pinning', 'ui.grid.selection', 'ui.grid.moveColumns', 'ui.grid.exporter', 'ui.grid.importer', 'ui.grid.grouping']);
     
    app.controller('MainCtrl',  ['$scope', '$http', '$timeout', '$interval', 'uiGridConstants', 'uiGridGroupingConstants',
     function ($scope, $http, $timeout, $interval, uiGridConstants, uiGridGroupingConstants) {
     
      $scope.gridOptions = {};
      $scope.gridOptions.data = 'myData';
      $scope.gridOptions.enableColumnResizing = true;
      $scope.gridOptions.enableFiltering = true;
      $scope.gridOptions.enableGridMenu = true;
      $scope.gridOptions.showGridFooter = true;
      $scope.gridOptions.showColumnFooter = true;
      $scope.gridOptions.fastWatch = true;
      //$scope.gridOptions.minRowsToShow = 5;
     
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
	      .success(function(data) {
	      
	        var i = 0;
	        data.forEach(function(row){
	          row.id = i;
	          i++;
	          $scope.myData.push(row);
	        });
	      });
      };
      
      $scope.refreshData();
      
      $scope.deleteBook = function(id){
          
	      $http.delete('http://localhost:8080/book/delete/'+id)
	      .sucess();
	  };
         
    }]);