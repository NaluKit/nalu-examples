# Nalu example using Domino-UI
This is a simple example that has three screens using [Domino-UI](https://github.com/DominoKit/domino-ui).

This example demonstrate a conditional composite. In case you select 'Homer Simpsons', you will see an additional composite.

## Using
To run the examples:

* clone the repository

* run `mvn clean install` & `mvn gwt:devmode`

* copy the link and paste the link into the browser url

## Note
This example does not have a server implementation. It uses a mock server on the client side.

## Implementation
This example has one shell, no plugins, etc. It uses Domino-UI as the widget library.

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

**Attention:**

This example has a filter implemented, that, in case 'Bart Simpsons' is selected from the list, the application will route to the search view. This is the desired behavior: see [BartSimpsonFilter](https://github.com/NaluKit/nalu-examples/blob/master/NaluDominoSimpleApplication/src/main/java/com/github/nalukit/example/nalu/simpleapplication/client/filters/BartSimpsonFilter.java)

This demonstrate how filters work.

In case you select 'Homer Simpson' you will see a conditional composite in action: see [DetailCompositeCondition](https://github.com/NaluKit/nalu-examples/blob/master/NaluDominoSimpleApplication/src/main/java/com/github/nalukit/example/nalu/simpleapplication/client/ui/application/content/detail/DetailCompositeCondition.java)