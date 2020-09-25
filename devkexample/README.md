# Example created for the DEVK-Meeting
This example was use at the DEVK-Meetup 'GWT vs. vue.js - a show down' on 07/03/2019 to demonstrates the use of Nalu, domino-rest and domino-ui.

It is a multi module project.

## Using
To run the examples:

* clone the repository

* run in one terminal window:

    - mvn clean verify

    - mvn gwt:codeserver -pl *-client -am

* in another terminal window:

    - mvn jetty:run -pl *-server -am -Denv=dev


To start the application, call:

http://localhost:8080/devkexample.html

**To login, you can enter any string your like ... no validation!**
Enter for 'S' or 'D' in the name search field to get a list of person.

## Note
This example has a server implementation. It uses domino-rest for the server communication.

## devkexample
Login example providing three shells:

1. application shell:
      * a header area
      * a footer area
      * a navigation area
      * a content area

2. error shell

3. login shell for accepting a user id and a password (is not checked, enter what ever you want ...)

The detail screen uses the Nalu composite feature.



