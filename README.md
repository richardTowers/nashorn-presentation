Nashorn Presentation
============================

Who am I?
----------------------------

I am Richard.

Thanks to The Skiff and Brandwatch.

What is this talk all about?
----------------------------

* A brief history of Java and JavaScript
* Nashorn - what is it and why?
* Nashorn - how does it work even?
* Progressive JavaScript - what is it and why?
* Progressive JavaScript on the JVM with Nashorn
* Not crazy enough? Let's Scala.

A brief history of Java and JavaScript
----------------------------

http://james-iry.blogspot.co.uk/2009/05/brief-incomplete-and-mostly-wrong.html :

1996 - "James Gosling invents Java. Java is a relatively verbose, garbage collected, class based, statically typed, single dispatch, object oriented language with single implementation inheritance and multiple interface inheritance. Sun loudly heralds Java's novelty."

1995 - "Brendan Eich reads up on every mistake ever made in designing a programming language, invents a few more, and creates LiveScript. Later, in an effort to cash in on the popularity of Java the language is renamed JavaScript. Later still, in an effort to cash in on the popularity of skin diseases the language is renamed ECMAScript."

1997 - Rhino invented at Netscape as part of the "Javagator" browser. Compiles JS into JVM bytecode. AMAZING technical achievement but: pig slow, leaks memory (no invokedynamic, so builds ad hoc classes which end up in PERMGEN).

2006 - jrunscript bundled in JDK 6. JavaScript touted as a cross-platform scripting langauge (alternative to bash / cmd).

2008 - JSR 292 (Da Vinci Machine) adds `invokedynamic` instruction, and some permgen wizadry, used by JRuby to great effect.

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
* Embed JS in Java application
** HelloWorld
** factorial (again)

Nashorn - how does it work even?
----------------------------

* There will be bytecode

Credits
----------------------------

https://en.wikipedia.org/wiki/Rhino_(JavaScript_engine)

http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/