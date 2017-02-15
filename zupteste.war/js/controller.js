app.controller('Controller', [ 'Service', '$scope', '$constants', function(Service, $scope, $constants) {
	
    $scope.fields = [];
    $scope.types = $constants.types;
    
    var _clearFields = function() {
    	$scope.fieldName = '';
    	$scope.fieldType = '';
    	$scope.notNull = false;
    };
    
    $scope.addNewModel = function() {
    	var newModel = {
    			modelName : $scope.modelName,
    			fields : $scope.fields
    	};
    	Service.addNewModel(newModel, function() {
    		$scope.result = 'Success!!!';
    	}, function() {
    		$scope.result = 'Error!!!';
    	});
    };
    
    $scope.addType = function() {
    	var field = {
    		fieldName : $scope.fieldName,
    		fieldType : $scope.fieldType,
    		notNull : $scope.notNull
    	}
    	$scope.fields.push(field);
    	_clearFields();
    };
    
    $scope.removeField = function(index){
    	$scope.fields.splice(index, 1);
    };
    
} ]);
