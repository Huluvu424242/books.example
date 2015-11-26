
var HomePage = function() {

	this.nav = element( by.css('navbar') );
	
	
	this.navigate = function() {
	    browser.get('/pages/books.html');
	};
 
	//  this.After(function(callback) {
	//    this.quit(callback);
	//  });
};

module.exports = new HomePage();


