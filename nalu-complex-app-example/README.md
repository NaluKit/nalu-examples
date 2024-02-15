# Nalu Complex App Example

This example should give you an impression how to set up a Nalu project and how to do things in Nalu.
It uses a lot of the Nalu features, shows Best Practice and can be use as base for your own complex application.

The example is based on 

* Nalu
* Domino-UI 
* Domino-REST

As long as you do not start the server again, your changes will be kept. 

There is no real user & password validation. Just enter something and press Login ...  

This example uses Java 17 and Spring Boot 3. To Downgrade set the java version to 11 and ths version of Spring Boot to something like 2.7.x.

## Run Instructions
To run the project, use the following command:

Change directory to your generated project and issue the following commands:

* run in one terminal window:

    - mvn clean compile

    - mvn gwt:codeserver -pl *-client -am

Once you see the url of the code server, run:

* in another terminal window:

    - mvn spring-boot:run -P env-dev

To start the application, call:

-> http://localhost:8080/index.html
