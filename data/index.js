//self-executing anonymous function pattern
//(function (data) {...})(express.exports);
(function (data) {
    
    var events = require("./events");
    var dataAccess = require("./dataAccess");
    
    
    //gets static data
    data.getEventsList = function (callback) {
        callback(null, events.initialEvents);
    };
    
    
    
    data.getEvent = function(categoryName, callback) {
        dataAccess.getDb(function(err, db) {
            if (err) {
                callback(err, null);
            } else {
                db.events.findOne({name: categoryName }, callback);
            }
        });
    }
    
    
      
    data.addEvent = function(categoryName, drink, callback) {
        dataAccess.getDb(function (err, db) {
            if (err) {
                callback(err, null);
            } else {
                db.events.update({ name: categoryName }, {$push: {values: drink} }, callback);
            }
        });
    }


        
    data.createNewEvent = function(categoryNme, callback) {
        dataAccess.getDb(function (err, db) {
            if (err) {
                callback(err, null);
            } else {

                db.events.find({ name: categoryNme }).count(function(err, count) {
                    if (err) {
                        callback(err, null);
                    } else {
                        if (count != 0) {
                            console.log(categoryNme + ' already exists!');
                        } else {
                            
                            //insert to db
                            var cat = {
                                name: categoryNme,
                                values: []
                            };
                            db.events.insert(cat, function (err) {
                                if (err) {
                                    callback(err);
                                } else {
                                    callback(null);
                                }
                            });
                        }
                    }
                });
            }
        });
    }


    function seedDatabase() {
        dataAccess.getDb(function(err, db) {
            if (err) {
                console.log("cannot seed database: " + err);
            } else {
                db.events.count(function(err, count) {
                    if (err) {
                        console.log("cannot seed database: " + err);
                    } else {
                        if (count == 0) {
                            console.log("Seeding database....");
                            events.forEach(function(item) {
                                db.drinks.insert(item, function(err) {
                                    if (err) {
                                        console.log("Failed to insert drink to database: " + err);
                                    }
                                });
                            });

                        } else {
                            console.log("Database seeded...");
                        }
                    }
                });
            }
        });
    }

   // Run seed database when you implement daataAccess
   // seedDatabase();

})(module.exports);