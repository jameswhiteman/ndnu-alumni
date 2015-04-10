var app = angular.module('app');

app.controller('cpanelCtrl', ['$scope', '$upload', '$http', function($scope, $upload, $http)
{
	 $scope.data = {
      selectedIndex : 0,
    };
    $scope.next = function() {
      $scope.data.selectedIndex = Math.min($scope.data.selectedIndex + 1, 2) ;
    };
    $scope.previous = function() {
      $scope.data.selectedIndex = Math.max($scope.data.selectedIndex - 1, 0);
    };
    $scope.setData = function(i) {
      $scope.data.selectedIndex = i ;
    };

    $scope.formData = {};
    // function to process the form
    $scope.submitForm = function() {
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "name="+$scope.formData.name.$modelValue+"&description="+$scope.formData.description.$modelValue+"&year="+$scope.formData.year.$modelValue;
        //info = "jj";
        console.log(info);
        $http.post('http://localhost:8282/ndnualumni-api/projects', info).
        success(function(data, status, headers, config) {
            alert("success");
            $state.go('home')
        }).
        error(function(data, status, headers, config) {
            alert("error");
        });
    };

    $scope.upload = function (files) {
        /*
        if (files && files.length) {
            for (var i = 0; i < files.length; i++) {
                var file = files[i];
                $upload.upload({
                    url: 'upload/url',
                    fields: {'username': $scope.username},
                    file: file
                }).progress(function (evt) {
                    var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                    console.log('progress: ' + progressPercentage + '% ' + evt.config.file.name);
                }).success(function (data, status, headers, config) {
                    console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
                });
            }
        }
        */
    };
}]);
