app.service('Service', [ '$http', '$constants', function($http, $constants) {
	return {
		addNewModel : function(data, successCallback, errorCallback) {
			$http({
				method : 'POST',
				url : $constants.restServer + '/addNewModel',
				data : angular.toJson(data),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(function (response) {
				successCallback();
				console.log('success');
			}, function (response) {
				errorCallback();
				console.log('error');
			});

		}
	};
} ]);