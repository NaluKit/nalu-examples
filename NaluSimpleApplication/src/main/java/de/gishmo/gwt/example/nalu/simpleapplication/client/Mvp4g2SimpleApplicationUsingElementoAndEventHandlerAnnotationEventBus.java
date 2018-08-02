/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package de.gishmo.gwt.example.nalu.simpleapplication.client;


import de.gishmo.gwt.example.nalu.simpleapplication.client.handler.SimpleApplicationHandler02;
import de.gishmo.gwt.example.nalu.simpleapplication.client.history.DetailHistoryConverter;
import de.gishmo.gwt.example.nalu.simpleapplication.client.history.HistoryName;
import de.gishmo.gwt.example.nalu.simpleapplication.client.history.ListHistoryConverter;
import de.gishmo.gwt.example.nalu.simpleapplication.client.history.SearchHistoryConverter;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.navigation.NavigationPresenter;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.shell.ShellPresenter;
import com.github.mvp4g.mvp4g2.core.eventbus.IsEventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Debug;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Event;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.EventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Start;
import com.github.mvp4g.mvp4g2.core.history.annotation.InitHistory;
import com.github.mvp4g.mvp4g2.core.history.annotation.NotFoundHistory;
import elemental2.dom.Element;

/**
 * Event bus of the SimpleMvp4G2Application example
 */
@EventBus(shell = ShellPresenter.class)
@Debug(logLevel = Debug.LogLevel.SIMPLE)
public interface Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus
  extends IsEventBus {

  /**
   * This event will be fire by the framework as first event
   * of the application.
   * <p>
   * We will use this event to initiate the setting of the
   * navigation in the west area of the shell by using the bind-attribute.
   * By using the start event to bind the navigation, we make sure
   * that the navigation will be updated before the content area is updated.
   */
  @Start
  @Event(bind = {NavigationPresenter.class})
  public void start();

  /**
   * This event will be used in case:
   * <p>
   * * there is not history-token
   * * the token is not valid
   */
  @InitHistory
  @NotFoundHistory
  @Event
  void initHistory();

  /**
   * This event will set the element (parameter) in the west
   * area of the shell.
   *
   * @param element the element of the widget, that will be
   *                displayed inside the west area of the shell.
   */
  @Event
  void setNavigation(Element element);

  /**
   * This event will set the element (parameter) in the content
   * area of the shell. We will use this event to update the shell
   * with the current content area.
   *
   * @param element the element of the widget, that will be
   *                displayed inside the content area of the shell.
   */
  @Event
  void setContent(Element element);

  /**
   * This event will update the content of the status bar.
   *
   * @param status the new message to display inside the status bar
   */
  @Event
  void setStatus(String status);

  /**
   * This event will display the detail screen inside the content of
   * the shell. The given id will be used to get the person from server
   * and display the view with the data, read rom the server.
   * <p>
   * This event will deactivate the the SimpleApplicationHandler02,
   * that means, the handler will not handle any event until we
   * activate the handler again!
   * <p>
   * We use the DetailHistoryConverter to convert the event to
   * the token which the framework will display after the url.
   * <p>
   * We will use the String representated by HistoryName.DETAIL
   * instead the event name inside the token.
   * <p>
   * This event will change the screen displayed inside the
   * content area. From the mvp4g2 point of view, it is a
   * navigation event. If there is a confirm-presenter defined,
   * this presenter will be asked before the view changed.
   *
   * @param id ID of the person to display
   */
  @Event(deactivate = {SimpleApplicationHandler02.class},
    historyConverter = DetailHistoryConverter.class,
    historyName = HistoryName.DETAIL,
    navigationEvent = true)
  void gotoDetail(long id);

  /**
   * This event will display the list screen inside the content of
   * the shell. The given parameters will be used to search the persons
   * and display the view with the data retrieved from the server.
   * <p>
   * This event will activate the the SimpleApplicationHandler02,
   * that means, the handler will handle any event until we
   * deactivate the handler again!
   * <p>
   * We use the ListHistoryConverter to convert the event to
   * the token which the framework will display after the url.
   * <p>
   * We will use the String representated by HistoryName.LIST
   * instead the event name inside the token.
   * <p>
   * This event will change the screen displayed inside the
   * content area. From the mvp4g2 point of view, it is a
   * navigation event. If there is a confirm-presenter defined,
   * this presenter will be asked before the view changed.
   *
   * @param searchName the name to search for
   * @param searchCity  the city to search or
   */
  @Event(activate = {SimpleApplicationHandler02.class},
    historyConverter = ListHistoryConverter.class,
    historyName = HistoryName.LIST,
    navigationEvent = true)
  void gotoList(String searchName,
                String searchCity);

  /**
   * This event will display the search screen inside the content of
   * the shell.
   * <p>
   * We use the SearchtHistoryConverter to convert the event to
   * the token which the framework will display after the url.
   * <p>
   * We will use the String representated by HistoryName.SEARCH
   * instead the event name inside the token.
   * <p>
   * This event will change the screen displayed inside the
   * content area. From the mvp4g2 point of view, it is a
   * navigation event. If there is a confirm-presenter defined,
   * this presenter will be asked before the view changed.
   *
   * @param searchName the name to search for
   * @param searchCity  the city to search or
   */
  @Event(historyConverter = SearchHistoryConverter.class,
    historyName = HistoryName.SEARCH,
    navigationEvent = true)
  void gotoSearch(String searchName,
                  String searchCity);

}
