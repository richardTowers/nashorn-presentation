Nashorn Presentation
============================

Who am I?
----------------------------

I am Richard.

Thanks to The Skiff and Brandwatch.

Questions for the Audience
----------------------------

* Who writes code for the web?
* Who has JS as part of their solution?
* Does anyone run JS on the server?
* Does anyone use Nashorn?

What is this talk all about?
----------------------------

* A brief history of Java and JavaScript
* Nashorn - what is it and why?
* Nashorn - how does it work even?
* Progressive JavaScript - what is it and why?
* Progressive JavaScript on the JVM with Nashorn and React
* Not crazy enough? Let's Scala.

A brief history of Java and JavaScript
----------------------------

http://james-iry.blogspot.co.uk/2009/05/brief-incomplete-and-mostly-wrong.html :

1996 - "James Gosling invents Java. Java is a relatively verbose, garbage collected, class based, statically typed, single dispatch, object oriented language with single implementation inheritance and multiple interface inheritance. Sun loudly heralds Java's novelty."

1995 - "Brendan Eich reads up on every mistake ever made in designing a programming language, invents a few more, and creates LiveScript. Later, in an effort to cash in on the popularity of Java the language is renamed JavaScript. Later still, in an effort to cash in on the popularity of skin diseases the language is renamed ECMAScript."

1997 - Rhino invented at Netscape as part of the "Javagator" browser. Compiles JS into JVM bytecode. AMAZING technical achievement but: pig slow, leaks memory (no invokedynamic, so builds ad hoc classes which end up in PERMGEN).

2006 - jrunscript bundled in JDK 6. JavaScript touted as a cross-platform scripting langauge (alternative to bash / cmd).

2011 - Java 7 includes JSR 292 (Da Vinci Machine), which adds `invokedynamic` instruction, and some permgen wizadry. Used by JRuby to great effect.

2014 - Java 8 released containing the Nashorn JS compiler.

The Glorious Future - Java 9 continues to improve JVM dynamic language support. JavaScript continues to eat the world.

Nashorn - what is it and why?
----------------------------

* Run JS on the JVM
** fact(170)
* Write "Cross Platform" scripts
** $ENV.PWD
** $EXEC("cat ../README.md")
** $OUT
** example
* Embed JS in Java application
** HelloWorld
** factorial (again)

Nashorn - how does it work even?
----------------------------

* There will be bytecode
* Mention optimistic typing
* Mention why JS makes this a nightmare.

Progressive JavaScript - what is it and why?
----------------------------

What?

* Run the same view code on the client and the server.
  Usually this means JS on the server.

Why?

* Users want apps that respond instantly -> Single page apps
* Single page apps are crap because:
** User must have JS
** User needs strong network connection to download resources
** Startup time is crap

Time for a patronising demo.

(HTTP2 will help a bit)

Progressive JavaScript on the JVM with Nashorn and React
----------------------------

* What is React? How does it help us wite progressive JS apps?
* How does this work in our case?
** Main Java class
** Main server JS
** Data classes
** Rendering JS, reuse on the client side
** Demo
*** Lynx / telnet

Who you trying to get crazy with esse? Don't you know I'm loco?
----------------------------

* So ScalaJS is a thing, and it works nicely with React too
** SPA demo
* Crazy idea:
	Scala -> JS -> Nashorn -> JVM Bytecode
         \-> JS -> Browser
* Less crazy idea: 
	Scala -> JVM Bytecode
         \-> JS -> Browser

* Did I get this working? No.

Credits / Links
----------------------------

https://en.wikipedia.org/wiki/Rhino_(JavaScript_engine)

https://en.wikipedia.org/wiki/Java_bytecode_instruction_listings

http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/
