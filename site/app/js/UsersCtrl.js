var app = angular.module('app');

app.controller('UsersCtrl', ['$scope', '$http', '$state', '$mdDialog', function($scope, $http, $state, $mdDialog)
{
 $http.get('http://localhost:8282/ndnualumni-api/users').
 success(function(data) {
  $scope.users = data;
}).
 error(function(data) {
   alert("Error fetching users data!");
 });

$scope.person;
$scope.search;
$scope.closeDialog = function() {
      // Easily hides most recent dialog shown...
      // no specific instance reference is needed.
      $mdDialog.hide();
    };

 $scope.goToPerson = function(selectedPerson, ev) {
     if (!selectedPerson.email)
         selectedPerson.email = "N/A";
     if (!selectedPerson.major)
         selectedPerson.major = "N/A";
     if (!selectedPerson.year)
         selectedPerson.year = "????";
     if (!selectedPerson.description)
         selectedPerson.description = "N/A";
    $scope.person = selectedPerson;
    var parentEl = angular.element(document.body);
    $mdDialog.show({
    parent: parentEl,
    controller: DialogController,
    scope: $scope.$new(),
    targetEvent: ev,
    templateUrl: 'temp/userDetail.html'
 });
};

    $scope.formattedPhone = function() {
        if (!$scope.person.phone)
            return "N/A";
        formatted = '(' + $scope.person.phone.substr(0, 3) + ') ' + $scope.person.phone.substr(3, 3) + '-' + $scope.person.phone.substr(6,4);
        return formatted;
    }

    $scope.getJob = function() {
        if (!$scope.person.title || !$scope.person.company) {
            return "N/A";
        }
        return $scope.person.title + " at " + $scope.person.company;
    }

    $scope.getPage = function() {
        if (!$scope.person.page) {
            return "#";
        }
        return $scope.person.page;
    }


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


}]);
