//GRUNT + NODEMON
//gruntfile.js - pure development asset, it is not used in production
//configures grunt task runner
//npm install grunt-cli -g (install globally )
//npm install grunt-nodemon --save-dev
//nodemon extension for node, running under grunt
//if any *.js is modified than nodemon restarts server.js
//just run grunt in console. If you need debugger, stop the grunt and run proj in debug mode

module.exports = function(grunt) {
    grunt.initConfig({
        nodemon: {
            all: {
                script: 'server.js',
                options: {
                    watchedExtensions: ['js']
                }
            }
        }        
    });


    grunt.loadNpmTasks('grunt-nodemon');
    grunt.registerTask('default', ['nodemon']);
}