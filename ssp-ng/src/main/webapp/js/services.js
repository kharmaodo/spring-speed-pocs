'use strict';

/* Services */
angular.module('shopping-list.services', ['ngResource']).

factory('ShoppingList', function($resource){
	return $resource('api/shop/:id', {id:'@id'});
});