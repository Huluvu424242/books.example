(function () {

    'use strict';

    // Karma configuration
    // Generated on Sun Jan 31 2016 18:46:45 GMT+0100 (CET)

    /*global module */
    module.exports = function (config) {
        config.set({

            // base path that will be used to resolve all patterns (eg. files, exclude)
            basePath: '',

            //urlRoot: '__karma__',

            // frameworks to use
            // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
            frameworks: ['jasmine2'],

            plugins: [
                'karma-coverage'
//                'karma-chrome-launcher',
//                'karma-firefox-launcher',
//                'karma-jasmine',
//                'karma-junit-reporter'
            ],

            // list of files / patterns to load in the browser
            files: [
                'test/spec/**/*.js',
//                'app/assets/libs/angular/angular.js',
//                'app/assets/libs/angular-route/angular-route.js',
//                'app/assets/libs/angular-mocks/angular-mocks.js',
//                'app/components/**/*.js'
                'public/app/**/*.js'
            ],

            // list of files to exclude
            exclude: [],

            // preprocess matching files before serving them to the browser
            // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
            preprocessors: {
                // source files, that you wanna generate coverage for 
                // do not include tests or libraries 
                // (these files will be instrumented by Istanbul) 
                'public/app/**/*.js': ['coverage']
            },

            // test results reporter to use
            // possible values: 'dots', 'progress'
            // available reporters: https://npmjs.org/browse/keyword/karma-reporter
            reporters: ['progress', 'coverage', 'junit'],

            // optionally, configure the reporter 
            coverageReporter: {
                reporters: [
                    {
                        type: 'html',
                        dir: '_reports/unit-coverage-html'
                    },
                    {
                        type: 'cobertura',
                        dir: '_reports/unit-coverage-cobertura'
                    },
                ]
            },


            junitReporter: {
                outputFile: '_reports/unit-results/test-results.xml'
            },


            // web server port
            port: 9876,

            // enable / disable colors in the output (reporters and logs)
            colors: true,

            // level of logging
            // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
            logLevel: config.LOG_INFO,

            // enable / disable watching file and executing tests whenever any file changes
            autoWatch: false,

            // start these browsers
            // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
            browsers: ['Chrome', 'PhantomJS'],

            // Continuous Integration mode
            // if true, Karma captures browsers, runs the tests and exits
            singleRun: true,

            // Concurrency level
            // how many browser should be started simultaneous
            concurrency: Infinity
        });
    };

}());
