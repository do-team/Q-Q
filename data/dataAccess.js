(function (database) {

    var mongodb = require("mongodb");
    //when mongodb sees tesData first it creates testData database for us
    var mongoUrl = "mongodb://localhost:27017/testDb";

    var db = null;

    database.getDb = function(callback) {
       if (!db) {

           mongodb.MongoClient.connect(mongoUrl,function(err, dbInstance) {
                if (err) {
                    callback(err,null);
                } else {
                    db = {
                        database: dbInstance,
                        drinks: dbInstance.collection("events"),
                        users: dbInstance.collection("actions")
                    };
                   callback(null, db);
               }  
           });

       } else {
           callback(null, db);
       } 
    }

})(module.exports);