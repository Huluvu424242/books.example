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
 
  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    concat: {
        options: {
          separator: ';',
        },
        dist: {
          src: ['js/**/*.js', 'jq/**/*.js'],
          dest: 'temp/allinone.js',
        },
    },
    concat_css: {
                option: {},
        dist: {
          src: ['css/**/*.css'],
          dest: 'temp/BootsFaces.css',
        },
    },
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      },
      build: {
        src: 'temp/allinone.js',
        dest: '../BootsFaces/min/js/BootsFaces.min.js'
      }
    },
    cssmin:{
      target: {
        files: [{
          expand: true,
          cwd: 'temp',
          src: ['BootsFaces.css'],
          dest: '../BootsFaces/min/css',
          ext: '.min.css'
        }]
      }    
    },
    mavenPrepare: {
      options: {
        resources: ['css/**', 'js/**', 'jq/**']
      },
      prepare: {}
    }, 
  });
 
  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-concat-css');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-maven');
   
  // Default task(s).
  grunt.registerTask('default', ['mavenPrepare', 'concat','uglify', 'concat_css','cssmin']);
 
};