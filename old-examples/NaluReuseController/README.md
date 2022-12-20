# Nalu example demonstrating the Controler Multi Route feature
This example demonstrates the Nalu Controller Multi Route Support.

The `Screen01Controller` is attached to the route: `application/screen01`.

Where as the `MultiScreenController` is attached to the following routes:
* `application/screen02`
* `application/screen03`
* `application/screen04`
* `application/screen05`


## Using
To run the examples:

* clone the repository

* run `mvn clean install` & `mvn gwt:devmode`

* copy the link and paste the link into the browser url

## Note
This example does not have a server implementation. It uses a mock server on the client side.

## Implementation
Example providing two shells:

1. application shell:
      * a header area
      * a footer area
      * a navigation area
      * a content area

2. error shell

The content are of the application shell will be used to show the three different components:

* a search component
* a list component (the result from the search)
* a detail component (a selected person from the list)

The detail screen uses the Nalu composite feature.


**Attention:** This example has a filter implemented, that, in case 'Bart Simpsons' is selected from the list, the application will route to the search view. This is the desired behavior: see [```BartSimpsonFilter```](https://github.com/NaluKit/nalu-examples/blob/master/NaluDominoCachedApplication/src/main/java/com/github/nalukit/example/nalu/simpleapplication/client/filters/BartSimpsonFilter.java)
