var app = angular.module('app');

app.controller('cpanelCtrl', function($scope, $http)
{
	 $scope.data = {
      selectedIndex : 0,
      tabLocked : true
    };
    $scope.next = function() {
      $scope.data.selectedIndex = Math.min($scope.data.selectedIndex + 1, 2) ;
    };
    $scope.previous = function() {
      $scope.data.selectedIndex = Math.max($scope.data.selectedIndex - 1, 0);
    };

    $scope.formData = {};
    
    // function to process the form
    $scope.submitForm = function() {
        alert('awesome!');  
    };
});

