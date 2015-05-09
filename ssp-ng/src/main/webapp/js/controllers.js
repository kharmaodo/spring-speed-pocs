'use strict';

/* Controllers */


function HomeController($scope, ShoppingList) {
	
	$scope.newItem = "";
	
	$scope.lists = ShoppingList.query(function() {
		$scope.currentList = $scope.lists[0];
	});
	
	$scope.loadList = function(list){
		$scope.currentList = ShoppingList.get({id:list.id});
	};
	
	$scope.createList = function(){
		var newShoppingList = new ShoppingList();
		newShoppingList.name = "Liste "+$scope.lists.length;
		newShoppingList.$save(function(){
			$scope.currentList = newShoppingList;
			$scope.lists = ShoppingList.query();
		});
	};

    $scope.deleteList = function(){
        $scope.currentList.$remove(function(){
            $scope.lists = ShoppingList.query(function() {
                $scope.currentList = $scope.lists[0];
            });
        });
    };
	
	$scope.addItem = function(){
		if ($scope.newItem.length === 0) return;

		if($scope.currentList.items == null){
			$scope.currentList.items = new Array();
		}
		
		$scope.currentList.items.push({
	      name: $scope.newItem,
	      quantity: 1
	    });
		
		$scope.currentList.$save();
	    $scope.newItem = '';
	};
	
	$scope.removeItem = function(item){
		$scope.currentList.items.splice($scope.currentList.items.indexOf(item), 1);
		$scope.currentList.$save();
	};
	
	$scope.updateList = function(){
		$scope.currentList.$save(function(){
			$scope.lists = ShoppingList.query();
		});
	};
}
HomeController.$inject = ['$scope', 'ShoppingList'];
