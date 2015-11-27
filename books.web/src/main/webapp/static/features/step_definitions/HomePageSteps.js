'use strict';

var assert = require('assert');
var chai = require('chai');
var expect = chai.expect;
var should = chai.should();


var steps = function() {
    
    var page = require('./HomePage.js');// page object
    
    
    this.Given(/^I am on the homepage$/, function(done) {
    	page.navigate();
    	done();
    });
    
    this.Then(/^I should see a element with ccs class "([^"]*)"$/, function(link, callback) {
    	console.log("LINK:"+link);
    	 //should.( page.nav.isPresent() ).to.be.ok;
    	console.log("PAGE_NAV:"+page.nav);
    	console.log("PAGE_NAV_VALUE:"+page.nav);
    	
    	callback.pending();
// support.isElementPresentByClass(this, link, function(result){
// result.should.equal(true);
// setTimeout(callback, 1000);
// });
    });
    
    
    this.Then(/^I should see a "([^"]*)" link$/, function(link, callback) {
        callback.pending();   
    });
    
    this.Then(/^I should not see a "([^"]*)" link$/, function(link, callback) {
        callback.pending();
// support.isElementPresent(this, link, function(result){
// result.should.equal(false);
// setTimeout(callback, 1000);
// });
    });
    
   
    
};

module.exports = steps;
