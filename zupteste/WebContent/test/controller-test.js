"use strict";
 
describe("Controller tests", function () {
 
	var controller, scope, httpBackend;
	
	beforeEach(module('app'));

	// Initialize the controller and a mock scope
	beforeEach(inject(function($controller, $rootScope, $httpBackend) {
		scope = $rootScope.$new();
		httpBackend = $httpBackend;
		
		controller = $controller('Controller', {
			$scope : scope
		});
		
	}));
	
	describe('When i try to add a field ', function() {
		it('should add the field to the list', function() {
			scope.fieldName = 'name';
			scope.fieldType = 'character varying';
			scope.notNull = true;
			expect(scope.fields.length).toBe(0);
			scope.addType();
			expect(scope.fields.length).toBe(1);
		});
	});
	
	describe('When i try to remove a field ', function() {
		it('should remove the field to the list', function() {
			scope.fieldName = 'name';
			scope.fieldType = 'character varying';
			scope.notNull = true;
			scope.addType();
			expect(scope.fields.length).toBe(1);
			scope.removeField(0);
			expect(scope.fields.length).toBe(0);
		});
	});
	
	describe('When i try to add a model ', function() {
		it('should return \'Success!!!\' if the returns OK', function() {
			scope.modelName = 'model_teste'
			scope.fieldName = 'name';
			scope.fieldType = 'character varying';
			scope.notNull = true;
			scope.addType();
			scope.addNewModel();
			httpBackend.when('POST', 'http://localhost:8080/zupteste/rest/addNewModel').respond(200, '');
			httpBackend.flush();
			expect(scope.result).toBe('Success!!!');
		});
		
		it('should return \'Error!!!\' if server returns an error', function() {
			scope.modelName = 'model_teste'
			scope.fieldName = 'name';
			scope.fieldType = 'character varying';
			scope.notNull = true;
			scope.addType();
			scope.addNewModel();
			httpBackend.when('POST', 'http://localhost:8080/zupteste/rest/addNewModel').respond(500, '');
			httpBackend.flush();
			expect(scope.result).toBe('Error!!!');
		});
	});
 
});