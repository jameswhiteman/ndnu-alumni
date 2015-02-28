var app = angular.module('app', ['ngMaterial']);



app.service("infoService", function ($http, $q)
{
	var deferred = $q.defer();
	$http.get('info.json').then(function (data)
	{
		deferred.resolve(data);
	});

	this.getNames = function ()
	{
		return deferred.promise;
	}
})

.controller("deptCtrl", function ($scope, infoService)
{
	var promise = infoService.getNames();
	promise.then(function (data)
	{
		$scope.names = data.data;
		console.log($scope.names);
	});
})