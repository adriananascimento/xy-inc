"use strict";
 
describe("Service tests", function () {
 
	beforeEach(module('app'));
	
	describe('When i try to add a model ', function() { 
		it('should return \'Success!!!\' if the returns OK', inject(function(Service, $httpBackend) {
			var newModel = {
	    			modelName : 'new_model',
	    			fields : [{
	    	    		fieldName : 'field_name',
	    	    		fieldType : 'numeric',
	    	    		notNull : true
	    	    	}]
	    	};
			var result; 
			Service.addNewModel(newModel, function() {
					result = true;
				}, function() {
					result = false;
				}
			);
			$httpBackend.when('POST', 'http://localhost:8080/zupteste/rest/addNewModel').respond(200, '');
			$httpBackend.flush();
			expect(result).toBeTruthy();
		}));
		
		it('should return \'Error!!!\' if the returns an error', inject(function(Service, $httpBackend) {
			var newModel = {
	    			modelName : 'new_model',
	    			fields : [{
	    	    		fieldName : 'field_name',
	    	    		fieldType : 'numeric',
	    	    		notNull : true
	    	    	}]
	    	};
			var result; 
			Service.addNewModel(newModel, function() {
					result = true;
				}, function() {
					result = false;
				}
			);
			$httpBackend.when('POST', 'http://localhost:8080/zupteste/rest/addNewModel').respond(500, '');
			$httpBackend.flush();
			expect(result).toBeFalsy();
		}));
	});
 
});