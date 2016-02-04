exports.config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',

    baseUrl: 'http://localhost:8000',

    capabilities: {
        'browserName': 'chrome'
    },

    specs: ['spec/**/*.js'],

    jasmineNodeOpts: {
        showColors: true,
        includeStackTrace: true,
        defaultTimeoutInterval: 30000
    },

    //    onPrepare: function () {
    //
    //        // Ensure the correct report dirs are created.
    //        require('mkdirp').sync('_reports/integration-results');
    //
    //        // `jasmine-reporters` needs jasmine to be in the global,
    //        // and protractor does not guarantee this until inside the
    //        // onPrepare function.
    //        require('jasmine-reporters');
    //
    //        jasmine.getEnv().addReporter(
    //            new jasmine.JUnitXmlReporter('_reports/integration-results', true, true)
    //        );
    //
    //        // Don't wait for Angular, this means we can use the same DSL as if
    //        // it *was* an Angular site.
    //        browser.ignoreSynchronization = true;
    //
    //        // The amount of time the driver should wait when searching for an
    //        // element if it is not immediately present.
    //        browser.manage().timeouts().implicitlyWait(10000);
    //
    //    }
};
