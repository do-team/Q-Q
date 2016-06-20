(function (eventsRestController) {

    var model = require("../Data");

    eventsRestController.init = function (app) {
        
        app.get("/api/events", function (req, res) {
            res.set("Content-type", "application/json");
            res.set('Charset', 'utf-8');
            model.getEventsList(function(err, results) {
                res.send(results);   
            });
        });


        app.get("/api/actions", function (req, res) {
             res.set("Content-type", "application/json");
            res.set('Charset', 'utf-8');
            res.send({"author": {"name": "Actions", "surname" : "actions"}, "type" : "abcd"});
            // model.getActions(function (err, results) {
            //     if (err) {
            //         console.log("Fetching data error : " + err);
            //     }
            //     res.send(results);
            // });
        });

    }

})(module.exports);