# Nalu example using GWT widgets
This example is using GWT widgets.

It is a small application with three screens. One screen to accept search parameters, one to show the search result and a detail screen.

This example is implemented using a single maven module.

It uses an error handler and error Route to display error messages. **This example does not use a hash.**

## Using
To run the examples:

* clone the repository

* run `mvn clean install` & `mvn gwt:devmode`

* copy the link and paste the link into the browser url

## Note
This example does not have a server implementation. It uses a mock server on the client side.

## Implementation
This example has one shell, no plugins, etc. It uses GWT widgets as the widget library.

**Attention:**
This example has a filter implemented, that, in case 'Bart Simpsons' is selected from the list, the application will route to the search view. This is the desired behavior: see [```BartSimpsonFilter```](https://github.com/NaluKit/nalu-examples/blob/master/NaluGwtSimpleApplication/src/main/java/com/github/nalukit/example/nalu/simpleapplication/client/filters/BartSimpsonFilter.java)

