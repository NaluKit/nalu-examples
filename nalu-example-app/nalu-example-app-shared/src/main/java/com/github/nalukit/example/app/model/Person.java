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

package com.github.nalukit.example.app.model;

import com.github.nalukit.malio.shared.annotation.field.MaxLength;
import com.github.nalukit.malio.shared.annotation.field.NotBlank;
import com.github.nalukit.malio.shared.annotation.field.NotEmpty;
import com.github.nalukit.malio.shared.annotation.field.NotNull;
import org.dominokit.jackson.annotation.JSONMapper;

@JSONMapper
public class Person {

  private long id;

  @NotNull
  @NotBlank
  @MaxLength(64)
  private String name;

  @NotNull
  @NotBlank
  @MaxLength(64)
  private String firstName;

  @NotEmpty
  private Address address;

  /* for serialization only */
  @SuppressWarnings("unused")
  public Person() {
    super();
  }

  public Person(long id,
                String name,
                String firstName,
                Address adress) {
    super();

    this.id        = id;
    this.name      = name;
    this.firstName = firstName;
    this.address   = adress;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

}
