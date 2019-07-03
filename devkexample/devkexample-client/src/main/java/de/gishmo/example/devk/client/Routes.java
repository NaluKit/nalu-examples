package de.gishmo.example.devk.client;

public class Routes {

  public final static String ROUTE_DETAIL = "/applicationShell/person/detail/:id";
  public final static String ROUTE_ERROR  = "/errorShell/error";
  public final static String ROUTE_LIST   = "/applicationShell/person/list/:name/:city";
  public final static String ROUTE_LOGON  = "/loginShell/login";
  public final static String ROUTE_SEARCH = "/applicationShell/person/search/:searchName/:searchCity";

  private Routes() {
  }

}
