'use strict';

/* Directives */


angular.module('shopping-list.directives', []).

directive('editable', function() {
	  return {
		    require: 'ngModel',
		    link: function(scope, elm, attrs, ctrl) {
		      
		    	
		      elm.blur(function(){
		    	  scope.$apply(function() {
			          ctrl.$setViewValue(elm.html());
			          var handler = scope.$eval(attrs.editable);
					  handler();
			      });
		      });
		      
		      ctrl.$render = function () {
					var value = ctrl.$viewValue;
					elm.html(value);
				};
		    }
		  };
		});