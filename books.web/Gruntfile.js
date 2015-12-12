/*
 * #%L
 * Books.App - Cucumber JS Tests
 * %%
 * Copyright (C) 2015 Pivotal Software, Inc.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
module.exports = function(grunt) {
    'use strict';

    // Load the plugins.
    require('load-grunt-tasks')(grunt);
    grunt.loadNpmTasks('grunt-protractor-runner');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-protractor-cucumber-html-report');
    grunt.loadNpmTasks('grunt-protractor-webdriver');
    grunt.loadNpmTasks('grunt-selenium-server');

    grunt
            .initConfig({
                pkg : grunt.file.readJSON('package.json'),

                jshint : {
                    files : [ '*.js', 'package.json' ],
                    options : {
                        globals : {
                            jQuery : true
                        }
                    }
                },

                connect : {
                    server : {
                        options : {
                            port : 8080,
                            hostname : 'localhost',
                            livereload : true,
                            base : '../src/main/webapp/static/'
                        }
                    }
                },

                protractor : {
                    options : {
                        configFile : "node_modules/protractor/referenceConf.json",
                        keepAlive : true, // trotz fehler weiter
                        noColor : false
                    },
                    target : {
                        options : {
                            configFile : "test/protractor.conf.js"
                        },
                    
                    }
                },

                protractor_webdriver : {
                    start : [ 'test/bdd/**/*.feature', 'test/bdd/**/*.js' ]
                },

                // protractor_cucumber_html_report : {
                // options : {
                // dest : '.',
                // output : 'report.html',
                // testJSONResultPath : '',
                // testJSONDirectory : ''
                // }
                // },

                'start-selenium-server' : {
                    dev : {
                        options : {
                            autostop : true,
                            downloadUrl : 'https://selenium-release.storage.googleapis.com/2.48/selenium-server-standalone-2.48.0.jar',
                            downloadLocation : 'node_modules/',
                            serverOptions : {},
                            systemProperties : {}
                        }
                    }
                },

                'stop-selenium-server' : {
                    dev : {}
                }

            });

    grunt.registerTask('default', [ 'jshint' ]);
    grunt.registerTask('startServer', 'Starts a http server.',
            [ 'connect:server:keepalive' ]);
    grunt.registerTask('test', [ 'start-selenium-server:dev', 'connect:server',
            'protractor:target' ]);
    grunt.registerTask('test1', 'Start the modul tests.', [ 'connect:server',
            'protractor:target' ]);

};
