package com.github.nalukit.nalu.complex.app.module.person.model;

import com.github.nalukit.nalu.complex.app.shared.model.Person;

public class ModelFactory {

  private static ModelFactory instance;

  private ModelFactory() {
  }

  public static ModelFactory get() {
    if (instance == null) {
      instance = new ModelFactory();
    }
    return instance;
  }

  public Person create() {
    return new Person();
  }

}
