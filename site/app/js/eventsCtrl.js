var app = angular.module('app');

app.controller('eventsCtrl', ['$scope', '$http', '$state', 'User', function($scope, $http, $state, $user)
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
    $scope.description = "";
    $scope.dateValue =  new Date();

    $scope.canDelete = function() {
        if ($user.getRole() === "User") {
            return true;
        }
        return false;
    };

    $scope.addEvent = function() {
        var meridianHours = 0;
        if ($scope.meridian === "PM") {
            meridianHours = 12;
        }
        $scope.dateValue = new Date($scope.year, $scope.month, $scope.day, $scope.hour + meridianHours, $scope.minute, 0, 0);
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "title="+$scope.title+"&type="+$scope.type+"&organizer="+$scope.organizer+"&major="+$scope.major+"&description="+$scope.description+"&time="+Math.floor($scope.dateValue.getTime());
        console.log(info);
        $http.post('http://localhost:8282/ndnualumni-api/events', info).
        success(function(data, status, headers, config) {
            $state.go('home')
        }).
        error(function(data, status, headers, config) {
            alert("Failed to create event.");
        });
    };

    $scope.deleteEvent = function(eventId) {
        $http.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
        $http.delete('http://localhost:8282/ndnualumni-api/events?id=' + eventId).
        success(function(data) {
            alert(data);
        }).
        error(function(data) {
           alert("Error deleting event.");
        });
    }
}]);
