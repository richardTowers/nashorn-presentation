var React = require('react');
var Html = require('./components/Html.jsx');
var ChatApp = require('./components/ChatApp.jsx');

module.exports = function (messages, target, expose) {
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

	var props = {
		threads: threads,
		thread: thread,
		messages: messages
	};
	var state = expose ? JSON.stringify(props) : undefined;

	props.messages = props.messages.filter(function (x) {
		return x.threadID === threadId;
	});

	var chatApp = React.createElement(ChatApp, props);
	var html = React.createElement(Html, {
		state: state,
		markup: React.renderToString(chatApp)
	});

	return html;
}