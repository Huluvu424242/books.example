exports.config = {
    getPageTimeout: 30000,
    allScriptsTimeout: 30000,
    seleniumAddress : 'http://localhost:4444/wd/hub',
    specs : [ 'features/*.feature' ],
    //output : 'report.html', 
    resultJsonOutputFile: 'report.json',
    //resultHtmlOutputFile: 'report.html',
    multiCapabilities : [ 
// {
// browserName : 'chrome',
// //'chrome.binary.path' : require('chrome').path,
// },
// {
// browserName : 'phantomjs',
//
// /*
// * Can be used to specify the phantomjs binary path. This can generally
// * be ommitted if you installed phantomjs globally.
// */
// 'phantomjs.binary.path' : require('phantomjs').path,
//
// /*
// * Command line args to pass to ghostdriver, phantomjs's browser driver.
// * See https://github.com/detro/ghostdriver#faq
// */
// 'phantomjs.ghostdriver.cli.args' : [ '--loglevel=DEBUG' ]
// },
    
    {
        browserName : 'firefox'
    } ],
    baseUrl : 'http://localhost:8080',
    
    // set to "custom" instead of cucumber.
    framework: 'custom',

    // path relative to the current config file
    frameworkPath: 'node_modules/protractor-cucumber-framework',

    // relevant cucumber command line options
    cucumberOpts: {
      format: "summary"
    },

};