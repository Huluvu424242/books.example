var HomePage = function() {

    this.welcome = element(by.tagName('H1'));
    console.log("WELCOME:"+this.welcome);

      
    this.navigate = function() {
        browser.get('/pages/books.html');
    };

};

module.exports = new HomePage();
