# Nalu examples
To help you to understand how the framework works, Nalu comes with some examples.

To run the examples:

* install nalu: [https://github.com/mvp4g/nalu-parent] and follow the instructions

* clone the repository

* run ```mvn clean``` & ```mvn gwt:devmode```

* copy the link and paste the link into the browser url

Please, keep in mind, Nalu ist a client side framework, so all server calls are simulated on the client side and are mocked in these examples. Because of that, there is no need for a server side implementation. Also, Nalu does not force you to use a special widget lib. This is up to you. In this examples we use native Elemental 2, Elemento, [Domino-UI](https://github.com/DominoKit/domino-ui) and native GWT widgets.

## Domino Example
The Domino example has three screens, a search-, list- and deatil-screen. You can navigatge between those screens, update data, etc. This example uses the Nalu-Plugin-Elemental2 and DominoUI as widget library. 

## Elemento Example
The Elemento example is similar to the Domino example, except that is uses Elemento instead of Domino-UI as widget library. This example uses the Nalu-Plugin-Elemental2. 

## Native GWT Example
The native GWT example is similar to the Elemento example, except that is uses native GWT widgets. This example uses the Nalu-Plugin-GWT. 

## Notes

Some things are nonsens and only implemented to show the features of Nalu.

For example: 
* If Bart Simpson is selected from the list, the application will route to the search view. This is the desired behavior: see [BartSimpsonFilter-class](https://github.com/mvp4g/nalu-examples/blob/master/NaluDominoSimpleApplication/src/main/java/de/gishmo/gwt/example/nalu/simpleapplication/client/filters/BartSimpsonFilter.java) for more informations.
