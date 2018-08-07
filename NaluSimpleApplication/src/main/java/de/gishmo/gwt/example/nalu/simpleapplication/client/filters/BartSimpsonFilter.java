package de.gishmo.gwt.example.nalu.simpleapplication.client.filters;

import com.github.mvp4g.nalu.client.application.IsFilter;

public class BartSimpsonFilter
  implements IsFilter {

  @Override
  public boolean filter(String route,
                        String... parms) {
    if ("/detail".equals(route)) {
      if ("3".equals(parms[0])) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String redirectTo() {
    return "/search";
  }

  @Override
  public String[] parameters() {
    return null;
  }
}
