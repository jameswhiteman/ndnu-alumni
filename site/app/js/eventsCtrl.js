var app = angular.module('app');

app.controller('eventsCtrl', ['$scope', '$http', '$state', function($scope, $http, $state)
{
    // Get
    $scope.events = "";
    $http.get('http://localhost:8282/ndnualumni-api/events').
    success(function(data) {
      $scope.events = data;
    }).
    error(function(data) {
       alert("Error fetching events data.");
    });

    // Add
    $scope.title = "";
    $scope.type = "";
    $scope.organizer = "";
    $scope.major = "";
    $scope.topic = "";
    $scope.description = "";
    $scope.dateValue =  new Date();

    $scope.addEvent = function() {
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "title="+$scope.title+"&type="+$scope.type+"&organizer="+$scope.organizer+"&major="+$scope.major+"&topic="+$scope.topic+"&description="+$scope.description+"&time="+Math.floor($scope.dateValue.getTime() / 10000);
        console.log(info);
        $http.post('http://localhost:8282/ndnualumni-api/events', info).
        success(function(data, status, headers, config) {
            $state.go('home')
        }).
        error(function(data, status, headers, config) {
            alert("Failed to create event.");
        });
    }
}]);
