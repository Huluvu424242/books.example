'use strict';

var chai = require('chai');
var expect = chai.expect;
var assert = chai.assert;
var should = chai.should();

var steps = function() {

    var page = require('./HomePage.js');

    this.Given(/^I am on the homepage$/, function() {
        return page.navigate();
       
        //done();
    });

    this.Then(/^I should see a element with ccs class "([^"]*)"$/, function(
            link) {
        return page.welcome.getText().then(function(text){
            console.log("TEXT"+text);
            assert.equal(text,'Bücherregal - Liste aller Bücher');
        });
       //console.log("!!! Wird niemals ausgeführt !!!");
        
    });

    this.Then(/^I should see a "([^"]*)" link$/, function(link) {
        //callback.pending();
    });

    this.Then(/^I should not see a "([^"]*)" link$/, function(link) {
        //callback.pending();
        // support.isElementPresent(this, link, function(result){
        // result.should.equal(false);
        // setTimeout(callback, 1000);
        // });
    });

};

module.exports = steps;
