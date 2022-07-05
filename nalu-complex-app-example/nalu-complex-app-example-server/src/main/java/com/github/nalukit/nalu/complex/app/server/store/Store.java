package com.github.nalukit.nalu.complex.app.server.store;

import com.github.nalukit.nalu.complex.app.shared.model.PersistanceData;
import com.github.nalukit.nalu.complex.app.shared.model.person.PersonSearch;

public class Store {

  private final static Store instance = new Store();

  private boolean         loggedIn = false;
  private PersistanceData persistanceData;

  private Store() {
    this.persistanceData = new PersistanceData(null,
                                               false,
                                               new PersonSearch());
  }

  public static Store get() {
    return instance;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public PersistanceData getPersistanceData() {
    return persistanceData;
  }

  public void setPersistanceData(PersistanceData persistanceData) {
    this.persistanceData = persistanceData;
  }
}
