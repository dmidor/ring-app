var gulp = require('gulp'),
    uglify = require('gulp-uglify'),
    sass = require('gulp-sass'),
    sourcemaps = require('gulp-sourcemaps'),
    watch = require('gulp-watch'),
    concat = require('gulp-concat'),
    rigger = require('gulp-rigger'),
    autoprefixer = require('gulp-autoprefixer'),
    ngAnnotate = require('gulp-ng-annotate'),
    templateCache = require('gulp-angular-templatecache'),
    properties = require('./src/main/static/src/bundles.json'),
    jshint = require('gulp-jshint');

var path = {
    build: {
        css: 'target/classes/static/css/',
        js: 'target/classes/static/min/',
    },
    src: {
        sass: 'src/main/static/sass/**/*.scss',
        js: 'src/main/static/src/**/*.js',
        templates: 'src/main/static/src/**/*.html'
    }
}

var buildJs = function(input, output) {
    gulp.src(properties.common.concat(input))
    // .pipe(sourcemaps.init())
        .pipe(concat(output))
        .pipe(ngAnnotate())
        // .pipe(uglify())
        // .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(path.build.js));
}

var autoprefixerOptions = {
    browsers: ['last 2 versions', '> 5%', 'Firefox ESR']
};

var watchedPath = null;

var getPathForLint = function(){
    if(watchedPath === null){
        return path.src.js;
    }else{
        return watchedPath;
    }
}

var setWatchedPath = function(path){
    watchedPath = path;
}

gulp.task('jshint', function() {
    return gulp.src(getPathForLint())
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
})

// embedding templates into index.js signup.js home.js is tricky as gulp-templatecache-plugin generates incorrect paths due to
// missing ** ,however it can be done - till then we will use single templates.js file
gulp.task('js:build-templates', function() {
    gulp.src(path.src.templates)
        .pipe(templateCache({ root: '/src', module: 'ring' }))
        .pipe(concat('templates.js'))
        .pipe(gulp.dest(path.build.js));
})

gulp.task('style:build', function() {
    gulp.src(path.src.sass)
        .pipe(sourcemaps.init())
        .pipe(sass({
            errLogToConsole: true,
            outputStyle: 'compressed'
        }))
        .pipe(sourcemaps.write())
        .pipe(autoprefixer(autoprefixerOptions))
        .pipe(gulp.dest(path.build.css))
})

gulp.task('watch', function() {
    watch([path.src.sass], function(vent, cb) {
        gulp.start('style:build');
    });
    watch([path.src.js], function(vent, cb) {
        setWatchedPath(vent.path);
        gulp.start('js:build');
        gulp.start('jshint');
    });
    watch([path.src.templates], function(vent, cb) {
        gulp.start('js:build-templates');
    });
})

gulp.task('build', function() {
    gulp.start('style:build');
    gulp.start('js:build');
    gulp.start('js:build-templates');
    gulp.start('jshint');
})

gulp.task('js:build', function() {
    gulp.start('concat-all');
})

gulp.task('concat-all', ['concat-index'])

gulp.task('concat-index', function() {
    buildJs(properties.index, 'index.js');
})
