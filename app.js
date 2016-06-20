var http = require('http');
var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var logger = require('morgan');
 
//Optional - enables getting form data and attach it to the body
//urlencoded is now part of middleware
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

//logger init
app.use(logger('dev'));

//set the public resources to be downloaded from server
app.use(express.static(__dirname + "/public"));

var ejsEngine = require("ejs-locals");
app.engine("ejs", ejsEngine);   //support master pages
app.set("view engine", "ejs");   //ejs view engine


//map routes
var controlelrs = require("./controllers"); //automatically insantiate index.js
controlelrs.init(app);

console.log("listening at port 3000");
module.exports = app;


// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
    res.render('error', {
      message: 'error',
      title: 'error',
      error: err
    });
});

app.listen (3000);