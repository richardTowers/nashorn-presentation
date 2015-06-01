var React = require('react');
var render = require('./render');

// Load the initial state:
var model =JSON.parse(document.querySelector('[data-data]').dataset.data);

// Re-render the view:
var html = render(model.messages, location.pathname, false);

React.render(html, document.documentElement);