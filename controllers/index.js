(function(controllers) {

    var mainController = require("./mainController.js");
    var eventsRestController = require("./eventsRestController.js");
    

    controllers.init = function(app) {
        mainController.init(app);
        eventsRestController.init(app);
    };

})(module.exports);