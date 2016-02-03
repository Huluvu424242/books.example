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
    }
};
