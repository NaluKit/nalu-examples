To run the project, use the following command:


Change directory to your generated project and issue the following commands:


* run in one terminal window:

    - mvn clean compile

    - mvn gwt:codeserver -pl *-client -am

* in another terminal window:

    - mvn jetty:run -pl *-server -am -Denv=dev


To start the application, call:

http://localhost:8080/index.html
