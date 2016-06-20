(function(mainController) {
    
    var model = require("../data");

    mainController.init = function (app) {
        

        app.get("/", function (req, res) {
            res.render("index", { title: "EJS View Engine", name: "Michal", isTrue: true, group: "Admin" });
        });
        
        
        app.get("/events", function (req, res) {
            model.getEventsList(function(err, results) {
                res.render("events", { title: "Events", name: "Events", events: results });
            });
        });


         app.get("/actions", function (req, res) {
            res.render("actions", { title: "Actions", name: "Actions"});
        });
        
       

    }

})(module.exports);