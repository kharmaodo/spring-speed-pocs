'use strict';

/* Services */
var shopingList = angular.module('shopping-list.services', ['ngResource']);



var list = function($resource){
	return $resource('api/shop/:id', {id:'@id'});
};

shopingList.factory('ShoppingList', [ '$resource', list ]);