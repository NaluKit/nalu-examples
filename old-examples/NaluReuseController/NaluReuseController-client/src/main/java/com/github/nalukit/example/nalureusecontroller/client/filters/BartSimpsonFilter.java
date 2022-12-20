package com.github.nalukit.example.nalureusecontroller.client.filters;

import com.github.nalukit.example.nalureusecontroller.client.Context;
import com.github.nalukit.nalu.client.filter.AbstractFilter;
import elemental2.dom.DomGlobal;

public class BartSimpsonFilter
    extends AbstractFilter<Context> {
  
  @Override
  public boolean filter(String route,
                        String... parms) {
    if (route.startsWith("/application/person/detail")) {
      if ("3".equals(parms[0])) {
        DomGlobal.window.alert("Bart Simpsons is not selecteable -> redirecting to search!");
        return false;
      }
    }
    return true;
  }
  
  @Override
  public String redirectTo() {
    return "/application/person/search";
  }
  
  @Override
  public String[] parameters() {
    return new String[] { this.context.getSearchName(),
        this.context.getSearchCity() };
  }
  
}
