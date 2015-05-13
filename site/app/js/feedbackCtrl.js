var app = angular.module('app');

app.controller('feedbackCtrl', ['$scope', '$http', '$state', 'User', function($scope, $http, $state, $user)
{
    $scope.feedbacks = "";
    $http.get('http://localhost:8282/ndnualumni-api/feedback').
    success(function(data) {
      $scope.feedbacks = data;
    }).
    error(function(data) {
       alert("Error fetching feedback data.");
    });

    $scope.userId = -1;
    $scope.response1 = "";
    $scope.response2 = "";
    $scope.response3 = "";
    $scope.response4 = "";
    $scope.response5 = "";
    $scope.addFeedback = function() {
        if (!$user.getIdentifier() || !$user.getVerifier()) {
            alert("You must be logged in to submit feedback.");
            return;
        }
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "userId="+$scope.userId+"&response1="+$scope.response1+"&response2="+$scope.response2+
            "&response3="+$scope.response3+"&response4="+$scope.response4+"&response5="+$scope.response5;
        $http.post('http://localhost:8282/ndnualumni-api/feedback', info).
        success(function(data, status, headers, config) {
            alert("Feedback submitted.");
            $state.go('home')
        }).
        error(function(data, status, headers, config) {
            alert("Failed to add feedback.");
        });
    }
}]);
