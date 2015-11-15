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

	var path = require('path');

	grunt.initConfig({

		env : {
			chrome : {
				PLATFORM : 'CHROME'
			},
			android : {
				PLATFORM : 'ANDROID'
			}
		},

		jshint : {
			files : [ 'Gruntfile.js', 'features/step_definitions/*.js',
					'features/support/*.js' ],
			options : {
				node : true,
				strict : true,
				globalstrict : true
			}
		},

		exec : {
			run_cucumber_tests : {
				command : 'nodejs ' + path.join('node_modules', 'cucumber', 'bin',
								'cucumber.js -f pretty -t ~@ignore')
			}
		}

	});

	grunt.loadNpmTasks('grunt-contrib-jshint');
	grunt.loadNpmTasks('grunt-exec');
	grunt.loadNpmTasks('grunt-env');

	grunt.registerTask('default', [ 'env:chrome', 'jshint', 'exec' ]);
	grunt.registerTask('android', [ 'env:android', 'jshint', 'exec' ]);

};