'use strict';

var assert = require('assert');


var steps = function() {
    
    var page = require('./HomePage.js');//page object
    
    
    this.Given(/^I am on the homepage$/, function(done) {
    	page.navigate();
    	done();
    });
    
    this.Then(/^I should see a "([^"]*)"$/, function(link, callback) {
    	
    	assert.equal(page.nav, link);
    	done()
//    	support.isElementPresentByClass(this, link, function(result){
//    		result.should.equal(true);
//    		setTimeout(callback, 1000);
//    	});
    });
    
    
    this.Then(/^I should see a "([^"]*)" link$/, function(link, callback) {
	support.findByBinding(this, link, function(result){
	    result.getText().then (function(text){
		text.trim().toLowerCase().should.equal(link.trim().toLowerCase());             
		setTimeout(callback, 1000);
	    });     
	});
    });
    
    this.Then(/^I should not see a "([^"]*)" link$/, function(link, callback) {
	support.isElementPresent(this, link, function(result){
	    result.should.equal(false);
	    setTimeout(callback, 1000);
	});
    });
    
   
    
};

module.exports = steps;
