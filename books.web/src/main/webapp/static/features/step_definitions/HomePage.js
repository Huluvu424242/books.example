var HomePage = function() {

    this.nav = element(by.css('navbar-brand'));

    this.navigate = function() {
        browser.get('/pages/books.html');
    };

};

module.exports = new HomePage();
