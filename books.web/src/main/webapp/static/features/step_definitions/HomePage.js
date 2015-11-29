var HomePage = function() {

    this.welcome = element(by.tagName('H1'));
    console.log("WELCOME:" + this.welcome);

    this.navigate = function() {
        browser.get('/pages/books.html');
    };

    this.navigateAndCallWithUrl = function(callback) {
        return browser.get('/pages/books.html').then(function() {
            browser.getCurrentUrl().then(function(url) {
                console.log("URL:" + url);
                callback(url);
            });
        });
    };

};

module.exports = new HomePage();
