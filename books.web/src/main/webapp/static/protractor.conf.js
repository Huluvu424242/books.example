exports.config = {
 seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['features/*.feature'],
  multiCapabilities: [{
    browserName: 'chrome'
  }, {
    browserName: 'firefox'
  }],
  baseUrl: 'http://localhost:8080',
  framework: 'cucumber'
};