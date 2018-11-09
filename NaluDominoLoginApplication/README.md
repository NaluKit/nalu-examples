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

### NaluDominoLoginApplication
Full featured example providing a shell with for areas:

* a header area
* a footer area
* a navigation area
* a content area

a login shell to get user-id and password and a error shell.

The content area will be used to show the three different components:

* a search componnt
* a list component (the result from the search)
* a detail comonent (a selected person from the list)

#### The Login example

Starting the application, the login shell gets visible. The credentials will not get validate, so enter a string for user-id and password, and press 'Login'. The example will a login flag inside the context.

In case the application gets reloaded, the flag is not and - instead showing the book marked page - the example routes to the login screen.

The login feature is implemented using a [Login Filter](https://github.com/NaluKit/nalu-examples/blob/master/NaluDominoLoginApplication/src/main/java/com/github/nalukit/example/nalu/loginapplication/client/filters/LoginFilter.java).


