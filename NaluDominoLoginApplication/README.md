# Nalu example demontrating the implementation of a login feature
This example demonstrates how to implement a lgoin feature into an application.

## Using
To run the examples:

* clone the repository

* run ```mvn clean``` & ```mvn gwt:devmode```

* copy the link and paste the link into the browser url

## Note
This example does not have a server implementation. It uses a mock server on the client side.

## NaluDominoLoginApplication
Full featured example providing two shells:

1. application shell:
      * a header area
      * a footer area
      * a navigation area
      * a content area

2. error shell

3. login shell that accepts a user id and a password

The detail screen uses the Nalu composite feature.

## The Login example

Starting the application, the login shell gets visible. The credentials will not get validate, so enter any string for user-id and password, and press 'Login'. The example will a login flag inside the context.

In case the application gets reloaded, the flag is not and - instead showing the book marked page - the example routes to the login screen.

The login feature is implemented using a [Login Filter](https://github.com/NaluKit/nalu-examples/blob/master/NaluDominoLoginApplication/src/main/java/com/github/nalukit/example/nalu/loginapplication/client/filters/BartSimpsonFilter.java).


