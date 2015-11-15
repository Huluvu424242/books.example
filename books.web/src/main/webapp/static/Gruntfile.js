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
  
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    watch: {
      cucumber: {
        files: ['features/**/*.js', 'script/**/*.js'],
        tasks: ['cucumberjs']
      }
    },
    cucumberjs: {
      src: 'features',
      options: {
        steps: 'features/step_definitions',
        format: 'pretty'
      }
    }
  });

  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-cucumber');

  //grunt.registerTask('watch-tests', 'Starts a watch for test automation.', ['watch:cucumber']);
  grunt.registerTask('default', 'Starts a watch for test automation.', ['watch:cucumber']);    
};