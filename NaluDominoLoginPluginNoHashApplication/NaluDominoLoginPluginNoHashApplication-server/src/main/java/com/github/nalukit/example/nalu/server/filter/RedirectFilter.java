/*
 * Copyright (c) 2018 - Frank Hossfeld
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

package com.github.nalukit.example.nalu.server.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectFilter
    implements Filter {

  private ServletContext context;

  @Override
  public void init(FilterConfig filterConfig)
      throws ServletException {
    this.context = filterConfig.getServletContext();
    this.context.log("RedirectFilter initialized");
  }

  @Override
  public void doFilter(ServletRequest servletRequest,
                       ServletResponse servletResponse,
                       FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String uri = request.getRequestURI();
    this.context.log("Requested Resource: " + uri);

    if (isInitialRequest(uri)) {
      if (uri.length() == 0) {
        response.sendRedirect("/index.html");
      } else if (uri.length() == 1 && uri.equals("/")) {
        response.sendRedirect("/index.html");
      } else {
        response.sendRedirect("/index.html?uri=" + uri);
      }
    } else {
      filterChain.doFilter(request,
                           response);
    }
  }

  @Override
  public void destroy() {
  }

  private boolean isInitialRequest(String uri) {
    if (uri.endsWith(".css")) {
      return false;
    }
    if (uri.endsWith(".js")) {
      return false;
    }
    if (uri.endsWith(".html")) {
      return false;
    }
    if (uri.endsWith(".ttf")) {
      return false;
    }
    if (uri.endsWith(".woff")) {
      return false;
    }
    if (uri.endsWith(".woff2")) {
      return false;
    }
    return true;
  }

}
