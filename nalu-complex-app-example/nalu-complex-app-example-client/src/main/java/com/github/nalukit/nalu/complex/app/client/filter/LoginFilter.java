package com.github.nalukit.nalu.complex.app.client.filter;

import com.github.nalukit.nalu.client.filter.AbstractFilter;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class LoginFilter
    extends AbstractFilter<AppContext> {

  @Override
  public boolean filter(String route,
                        String... parms) {
    if (!Routes.ROUTE_LOGON.equals(route)) {
      //      if (!this.context.isLoggedIn()) {
      //        return false;
      //      }
    }
    return true;
  }

  @Override
  public String redirectTo() {
    return "/loginShell/login";
  }

  @Override
  public String[] parameters() {
    return new String[] {};
  }

}
