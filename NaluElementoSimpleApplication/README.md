# Nalu example using Elemento
This is a simple example that has three screens using [Elemento](https://github.com/hal/elemento)

## Using
To run the examples:

* clone the repository

* run `mvn clean install` & `mvn gwt:devmode`

* copy the link and paste the link into the browser url

## Note
This example does not have a server implementation. It uses a mock server on the client side.

## Implementation
This example has one shell, no plugins, etc. It uses Elemento as the widget library.

## NaluDominoSimpleApplication
Full featured example providing a shell with four areas:

1. application shell:
      * a header area
      * a footer area
      * a navigation area
      * a content area

The content area will be used to show the three different components:

* a search componnt
* a list component (the result from the search)
* a detail comonent (a selected person from the list)
