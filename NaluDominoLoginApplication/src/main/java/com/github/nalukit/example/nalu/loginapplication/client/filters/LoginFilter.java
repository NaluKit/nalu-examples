package com.github.nalukit.example.nalu.loginapplication.client.filters;

import com.github.nalukit.example.nalu.loginapplication.client.NaluLoginApplicationContext;
import com.github.nalukit.nalu.client.filter.AbstractFilter;
import elemental2.dom.DomGlobal;

public class LoginFilter
    extends AbstractFilter<NaluLoginApplicationContext> {

  @Override
  public boolean filter(String route,
                        String... parms) {
    if (!"/loginShell/login".equals(route)) {
      if (!this.context.isLoggedIn()) {
        DomGlobal.window.alert("User is not logged in! Redirect to Login screen!");
        return false;
      }
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
