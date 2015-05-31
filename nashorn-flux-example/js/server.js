var React = require('react');
var Html = require('./components/Html.jsx');
var ChatApp = require('./components/ChatApp.jsx');

function toArray (input) {
	var output = [];
	for (var key in input) { output.push(input[key]); }
	return output;
}

global.render = function () {

	var ExampleData = Java.type('org.nashornExample.ExampleData');
	var messages = toArray(ExampleData.getMessages());

	var props = {
		threads: [],
		thread: {},
		messages: messages
	};

	var chatApp = React.createElement(ChatApp, props);
	var html = React.createElement(Html, {
		markup: React.renderToString(chatApp)
	});
	return React.renderToString(html);
};