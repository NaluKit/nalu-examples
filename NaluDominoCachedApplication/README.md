# Nalu examples
Here you find examples that implement the [Nalu application framework](ToDo).

## Using
To run the examples:

* install nalu: [https://github.com/nalukit/nalu] and follow the instructions

* clone the repository

* run ```mvn clean``` & ```mvn gwt:devmode```

* copy the link and paste the link into the browser url

## Examples
The examples implement different features or use different widget libs. All examples are using client side data services. Of course, you can replace them with your prefered way getting data from the server.

### NaluDominoCachedApplication
Full featured example providing a shell with for areas:

* a header area
* a footer area
* a navigation area
* a content area

The content area will be used to show the three different components:

* a search componnt
* a list component (the result from the search)
* a detail comonent (a selected person from the list)

Some things may look a bit strange or have no real sense. F.e.: If Bart Simpson is selected from the list, the application will route to the search view. This is the desired behavior: see [```BartSimpsonFilter```](https://github.com/NaluKit/nalu-examples/blob/master/NaluDominoCachedApplication/src/main/java/com/github/nalukit/example/nalu/simpleapplication/client/filters/BartSimpsonFilter.java)

#### The Chache Feature
This example implements the cache feature.

To see the cache working,

* search for persons
* press 'Store in Chache'
* select a person
* change a value
* press 'Save'

This example will route back to the list. In case 'Store in Cache' is active, the change is not visible, because Nalu uses the saved component instead of creating a new one. After pressing 'Reload', the updates gets visible.
