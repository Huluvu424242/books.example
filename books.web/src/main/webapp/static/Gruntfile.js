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
    grunt.loadNpmTasks('grunt-karma');
    grunt.loadNpmTasks('grunt-protractor-runner');
    
    grunt.initConfig({
	pkg: grunt.file.readJSON('package.json'),	  
	
	'protractor-cucumber-html-report': {
	    options: {
		dest: '.',
		output: 'report.html',
		testJSONResultPath: '',
		testJSONDirectory: '',
	    },
	},
	
	
	'connect': {
            server:{
		options: {
		    port:8080,
		    hostname: 'localhost',
		    livereload: true,
		    base: '../src/main/resources/static/'
		}
            }
	},

	'karma': {
            unit: {
		configFile: 'karma.conf.js',
		singleRun: true
            }
	},
	
	'protractor_webdriver': {
	    target: {
		options: {
		},
	    },
	},
	
	'protractor': {
	    options: {
		configFile: "node_modules/protractor/referenceConf.json", // Default config file
		keepAlive: true, // If false, the grunt process stops when the test fails.
		noColor: false, // If true, protractor will not use colors in its output.
	    },
	    target: {   // Grunt requires at least one target to run so you can simply put 'all: {}' here too.
		options: {
		    configFile: "protractor.conf.js" // Target-specific config file
		}
	    }
	},
	
	'cucumberjs': {
	    options: {
		format: 'html',
		output: 'cucumber_report.html',
		theme: 'simple'
	    },
	    my_features: ['features/*.feature']
	},


	//	webdrivermanager: {
	//	    out_dir: './selenium',
	//	    capabilities: {
	//		browserName: 'chrome'
	//	    },
	//	    seleniumArgs: [],
	//	    seleniumPort: 4444,
	//	    ignore_ssl: false,
	//	    proxy: false,
	//	    method: 'GET',
	//	    webdriverVersions: {
	//		selenium: '2.44.0',
	//		chromedriver: '2.12',
	//		iedriver: '2.44.0'
	//	    }
	//	},
	
	//	
	//	cucumber: {
	//	    src: 'features',
	//	    options: {
	//		steps: 'features/step_definitions',
	//		format: 'pretty'
	//	    }
	//	}
	
    });
    
    //  grunt.loadNpmTasks('grunt-contrib-jshint');
    //  grunt.loadNpmTasks('grunt-contrib-connect');
    //  grunt.loadNpmTasks('grunt-webdriver-manager');
    //  grunt.loadNpmTasks('grunt-contrib-jasmine');
    //  grunt.loadNpmTasks('grunt-browserify');
    //  grunt.loadNpmTasks('cucumber');
    grunt.loadNpmTasks('grunt-protractor-webdriver');
    //    
    grunt.registerTask('startServer', 'Starts a http server.', ['connect:server:keepalive']);
    grunt.registerTask('unitTest', 'Start the modul tests.', ['connect','protractor']);
    
    grunt.registerTask('default', [
	'connect',
	'protractor_webdriver',
	'protractor'
    ]);
    
};
