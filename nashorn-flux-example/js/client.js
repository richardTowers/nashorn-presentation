var React = require('react');
var render = require('./render');

// Load the initial state:
var model = JSON.parse(document.querySelector('[data-data]').dataset.data);

console.log(model);

// Re-render the view:
function rerender () {
	var html = render(model.messages, location.pathname, false);
	React.render(html, document.documentElement);
}

document.addEventListener('click', function (event) {
    if (event.target.tagName === 'A') {
        history.pushState({}, null, event.target.getAttribute('href'));
        rerender();
        event.preventDefault();   
    }
});

document.addEventListener('keypress', function (event) {
   var newMessage;
   var matches;
   var threadID;

   if (event.target.tagName === 'TEXTAREA' && event.keyCode === 13) {
	   matches = /\/thread\/([^\/]+)/.exec(location.pathname);
	   threadID = (matches && matches[1]) || model.thread.id;
       newMessage = {
       		id         : model.messages[model.messages.length - 1].id+ 1,
			threadID   : threadID,
			threadName : model.thread.name,
			authorName : 'Rich',
			text       : event.target.value,
			timestamp  : new Date().toJSON()
       };
       model.messages.push(newMessage);
       rerender();
   }
});