var React = require('react');
var render = require('./render');

global.render = function (path) {
	var ExampleData = Java.type('org.nashornExample.ExampleData');
	
	// Convert Java array to a native js array:
	var messages = Java.from(ExampleData.getMessages())
		// Convert messages to native JS message types so they can be serialized:
		.map(function (message) {
			return {
				id         : message.id,
				threadID   : message.threadID,
				threadName : message.threadName,
				authorName : message.authorName,
				text       : message.text,
				timestamp  : message.timestamp
			}
		});

	var html = render(messages, path, true);

	return React.renderToString(html);
};