# Example demontrating the plugin feature
This example demonstrates the use of plugins in Nalu. It is a multi module project.

## Using
To run the examples:

* clone the repository

* run ```mvn gwt:codeserver -pl *-client -am``` in one terminal window

* run ```mvn jetty:run -pl *-server -am -Denv=dev``` in another terminal window

To start the application, call:

http://127.0.0.1:8080/index.html


## Note
This example does not have a server implementation. It uses a mock server on the client side.

## NaluDominoLoginPluginApplication
Login example providing three shells:

1. application shell:
      * a header area
      * a footer area
      * a navigation area
      * a content area

2. error shell

3. login shell for accepting a user id and a password

The detail screen uses the Nalu composite feature.

The classes used to implement the login feature a seperated module. The error handling is done using an ErrorPopUpController inside the main module.

## The Login example

Starting the application, the login shell gets visible. The credentials will not get validate, so enter any string for user-id and password, and press 'Login'. The example will a login flag inside the context.

In case the application gets reloaded, the flag is not set and - instead showing the book marked page - the example routes to the login screen.

The login feature is implemented using a [Login Filter](https://github.com/NaluKit/nalu-examples/blob/master/NaluDominoLoginPluginApplication/NaluDominoLoginPluginApplication-client/src/main/java/com/github/nalukit/example/nalu/loginapplication/filters/BartSimpsonFilter.java).


