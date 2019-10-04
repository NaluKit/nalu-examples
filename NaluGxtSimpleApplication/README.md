# Nalu example using GXT widgets
This example uses GXT GPL v4.0.0 as widget lib.

It is a small mail application with a list of mails on the top. Select one mail and it gets display on the lower side.

This example is implemented using a single maven module.

It uses an error popup to display error messages.

## Using
To run the examples:

* clone the repository

* run `mvn clean install`

* to start use: `mvn gwt:devmode`

* use  `http://127.0.0.1:8888/index.html` as URL

## Note
This example does not have a server implementation. It uses a mock server on the client side.

## Implementation
This example has one shell, no plugins, etc. It uses GWT widgets as the widget library.
