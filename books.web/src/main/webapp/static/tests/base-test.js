var ptor = protractor.getInstance ? protractor.getInstance() : browser;

describe('basis test', function(){
	beforeEach(function(){
		//Nix
	});
	
	it('navigate to homepage', funtion(){
		browser.get('http://localhost:8080');
		expect(element(by.tagName('header')).isDisplayed()).toBeTruthy();
	});
	
	afterEach(function(){
		//Nix
	});
})
