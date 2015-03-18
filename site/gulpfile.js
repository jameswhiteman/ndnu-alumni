var gulp        = require('gulp'),
    livereload  = require('gulp-livereload'),
    browserSync = require('browser-sync');

// start server
gulp.task('browser-sync', function() {
    browserSync({
        server: {
            baseDir: "./app"
        }
    });
});

gulp.task('html', function () {
    return gulp.src('./app/*.html')
        .pipe(browserify())
        .pipe(uglify())
        .pipe(gulp.dest('app/'));
});

// use default task to launch BrowserSync and watch JS files
gulp.task('default', ['browser-sync'], function () {

    // add browserSync.reload to the tasks array to make
    // all browsers reload after tasks are complete.
    gulp.watch("./app/*.html", ['html', browserSync.reload]),
    gulp.watch("./app/temp/*.html", ['html', browserSync.reload]);
});