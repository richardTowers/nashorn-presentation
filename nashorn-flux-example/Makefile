all: build/server.js build/client.js
	mvn clean compile exec:java

clean:
	rm -f build/*

build/server.js:
	node node_modules/.bin/browserify -t reactify js/server.js --standalone server > $@

build/client.js:
	node node_modules/.bin/browserify -t reactify js/client.js > $@