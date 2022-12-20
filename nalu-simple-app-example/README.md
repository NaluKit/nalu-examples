# Nalu Simple App Example - WORK IN PROGRESS!

This example shows the minimal coding to start with a Nalu project. Domino-UI and Domino-Rest are added as dependencies, just to make the start easier. Both depencies can be replaced / removed.

## Run Instructions
To run the project, use the following command:

Change directory to your generated project and issue the following commands:

* run in one terminal window:

    - mvn clean compile

    - mvn gwt:codeserver -pl *-client -am (Windows: mvn gwt:DEVMODE -pl *-client -am)

Once you see the url of the code server, run:

* in another terminal window:

    - mvn spring-boot:run -P env-dev

To start the application, call:

-> http://localhost:8080/index.html