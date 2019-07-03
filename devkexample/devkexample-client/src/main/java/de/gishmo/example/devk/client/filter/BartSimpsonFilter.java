/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package de.gishmo.example.devk.client.filter;

import com.github.nalukit.nalu.client.filter.AbstractFilter;
import de.gishmo.example.devk.client.ApplicationContext;
import de.gishmo.example.devk.client.Routes;
import elemental2.dom.DomGlobal;

public class BartSimpsonFilter
    extends AbstractFilter<ApplicationContext> {

  @Override
  public boolean filter(String route,
                        String... parms) {
    if (route.startsWith("/applicationShell/person/detail")) {
      if ("3".equals(parms[0])) {
        DomGlobal.window.alert("Bart Simpsons is not selecteable -> redirecting to search!");
        return false;
      }
    }
    return true;
  }

  @Override
  public String redirectTo() {
    return Routes.ROUTE_SEARCH;
  }

  @Override
  public String[] parameters() {
    return new String[] { this.context.getSearchName(),
                          this.context.getSearchCity() };
  }

}
