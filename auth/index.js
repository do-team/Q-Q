(function(auth) {

    var data = require("../data");
    var hasher = require("./hasher");

    auth.init = function(app) {
        app.get("register", function(req, res) {
            res.render("register", {title: "Register for the Board" });
        });

        app.post("register", function (req, res) {
            var salt = hasher.createSalt();

            var user = {
                email: req.body.email,
                passwordHash: hasher.computeHash(req.body.password, salt), 
                salt: salt 
            };
        });

        data.addUSer(user, function(err) {
            if (err) {
                res.render("register", { title: "Error Register new User" });
            } else {
                res.redirect("login");
            }
        });
    }

})(module.exports);