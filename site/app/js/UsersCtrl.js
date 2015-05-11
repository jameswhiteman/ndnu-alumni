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


$scope.closeDialog = function() {
      // Easily hides most recent dialog shown...
      // no specific instance reference is needed.
      $mdDialog.hide();
    };

 $scope.goToPerson = function(firstName, lastName, year, major, email, phone, description, ev) {
  var parentEl = angular.element(document.body);
  $mdDialog.show({
   parent: parentEl,
   controller: DialogController,
   scope: $scope.$new(),
   targetEvent: ev,
   template:
   '<md-dialog flex="25">'+ 
   '<md-content layout="column" layout-align="space-between center">'+
   '<md-subheader class="md-sticky-no-effect">Alumni Card</md-subheader>'+
   '<div layout="column" layout-padding>'+
   '<p><md-icon md-svg-src="img/icons/ic_person_24px.svg" class="name" style="color: dodgerblue;"></md-icon>'+
   '<span>' + '   ' + lastName + ', ' + firstName + '</span></p>'+
   '<p><md-icon md-svg-src="img/icons/grad_cap.svg" class="name"></md-icon>'+
   '<span>' + '   ' + major + ', ' + year + '</span></p>'+
   '<p><md-icon md-svg-src="img/icons/ic_phone_24px.svg" class="name"></md-icon>'+
   '<span>' + '   ' + email + ', ' + phone + '</span></p>'+
   '<p><md-icon md-svg-src="img/icons/message.svg" class="name"></md-icon>'+
   '<span>' + '   ' + description + '</span></p>'+
   '<md-button ng-click="closeDialog()" class="md-primary">Ok!</md-button>'+
   '</md-content>'+
   '</md-dialog>'

 })
};


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
