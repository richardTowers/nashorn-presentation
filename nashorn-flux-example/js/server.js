var React = require('react');
var Html = require('./components/Html.jsx');
var ChatApp = require('./components/ChatApp.jsx');

function toArray (input) {
	var output = [];
	for (var key in input) { output.push(input[key]); }
	return output;
}

global.render = function (target) {

	var ExampleData = Java.type('org.nashornExample.ExampleData');

	// React does not like native Java arrays (because they don't have `hasOwnProperty`)
	var messages = toArray(ExampleData.getMessages());

	// TODO: use the stores:
	var thread = {};
	var threads = [];
	messages.forEach(function(message) {
        var threadID = message.threadID;
        thread = {
            id: threadID,
            name: message.threadName,
            lastMessage: message
        };
        threads.push(thread);
    });

	var threadId;
	var matches = /\/thread\/([^\/]+)/.exec(target);
	if (matches) {
		threadId = matches[1];
	}
	else {
		threadId = thread.id;
	}
	messages = messages.filter(function (x) {
		return x.threadID === threadId;
	});

	var props = {
		threads: threads,
		thread: thread,
		messages: messages
	};

	var chatApp = React.createElement(ChatApp, props);
	var html = React.createElement(Html, {
		markup: React.renderToString(chatApp)
	});
	return React.renderToString(html);
};