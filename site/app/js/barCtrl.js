var app = angular.module('app');

app.controller('barCtrl', function($scope, $mdDialog) 
{
	 $scope.showAdvanced = function(ev) {
    $mdDialog.show({
      controller: DialogController,
      templateUrl: 'temp/logIn.html',
      targetEvent: ev,
    })
    .then(function(answer) {
      $scope.alert =  answer;
    }, function() {
      $scope.alert = 'You cancelled the dialog.';
    });
  };
});
function DialogController($scope, $mdDialog) {
  $scope.hide = function() {
    $mdDialog.hide();
  };
  $scope.cancel = function() {
    $mdDialog.cancel();
  };
  $scope.answer = function(answer) {
    $mdDialog.hide(answer);
  };
}

