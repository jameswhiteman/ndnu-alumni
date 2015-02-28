angular
.module('app')
.controller('deptCtrl', function( $scope ) {
    $scope.data = {
      selectedIndex : 0,
      secondLocked : true,
      secondLabel : "S"
    };
    $scope.next = function() {
      $scope.data.selectedIndex = Math.min($scope.data.selectedIndex + 1, 2) ;
    };
    $scope.previous = function() {
      $scope.data.selectedIndex = Math.max($scope.data.selectedIndex - 1, 0);
    };
  });