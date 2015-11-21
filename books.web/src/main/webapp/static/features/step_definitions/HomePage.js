
var HomePage = function() {

	this.navigate = function() {
	    browser.get('/');
	};
 
	//  this.After(function(callback) {
	//    this.quit(callback);
	//  });
};

module.exports = new HomePage();


