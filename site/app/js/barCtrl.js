var app = angular.module('app');

app.controller('barCtrl', ['$scope','$mdDialog', '$state', 'User', function($scope, $mdDialog, $state, $user)
{
    $scope.getCpanelText = function() {
        if ($user.getRole() === "User") {
            return "Control Panel";
        }
        return "";
    }
    $scope.getLoginText = function() {
        if (!$user.getIdentifier() || !$user.getVerifier()) {
            return "Log In";
        }
        return "Log Out";
    }
	 $scope.showAdvanced = function(ev) {
         console.log($scope.identifier + ";" + $scope.verifier);
         if ($user.getIdentifier() != "" && $user.getVerifier() != "") {
             $user.setIdentifier("");
             $user.setVerifier("");
             $user.setName("");
             $user.setRole("");
             return;
         }
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

  $scope.showControlPanel = function() {
      if ($user.getRole() === "User")
          $state.go("cpanel");
  };
$scope.cpanelText = "";
  $scope.updateControlPanelText = function() {
      if ($user.getRole() == "User") {
          $scope.cpanelText = "Control Panel";
      }
      else {
          $scope.cpanelText = "";
      }
  }
}]);

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
