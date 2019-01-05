/*
 * Copyright (c) 2019 - Frank Hossfeld
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

package com.github.nalukit.example.nalu.simpleapplication.server.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class RedirectFilter
    implements Filter {

  private ServletContext context;

  @Override
  public void init(FilterConfig filterConfig)
      throws ServletException {
    this.context = filterConfig.getServletContext();
    this.context.log("RedirectFilter initialized");
  }

  // localhost:8080/App/applicationShell/person/detail/1?key01=value01&key02=value02#myhash
  @Override
  public void doFilter(ServletRequest servletRequest,
                       ServletResponse servletResponse,
                       FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String uri = request.getRequestURI();
    this.context.log("Requested Resource: " + uri);
    this.context.log("context.getContextPath(): " + this.context.getContextPath());
    this.context.log("context.getServletContextName(): " + this.context.getServletContextName());

    if (isInitialRequest(uri)) {
      StringBuilder sbUrl = new StringBuilder();
      sbUrl.append(request.getContextPath())
           .append("/index.html");
      sbUrl.append("?");
      if (!Objects.isNull(request.getQueryString())) {
        sbUrl.append(request.getQueryString())
             .append("&");
      }
      sbUrl.append("uri=")
           .append(request.getRequestURI());
      this.context.log(sbUrl.toString());
      response.sendRedirect(sbUrl.toString());

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
    if (uri.endsWith(".ico")) {
      return false;
    }
    if (uri.endsWith(".png")) {
      return false;
    }
    return true;
  }

}
