var app = angular.module('app');

app.controller('toastCtrl', ['$scope', '$http', '$state', 'Toast', function($scope, $http, $state, $toast)
{
    $scope.text = $toast.getText();
}]);
