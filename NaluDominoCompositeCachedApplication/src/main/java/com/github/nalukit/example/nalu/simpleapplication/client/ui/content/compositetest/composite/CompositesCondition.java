package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.composite;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractCompositeCondition;

/**
 * Stupid composite condition.
 *
 * Will return true in case even number, otherwise false;
 * In case it is not a number, It will return false;
 */
public class CompositesCondition
    extends AbstractCompositeCondition<NaluSimpleApplicationContext> {

  @Override
  public boolean loadComposite(String route,
                               String... params) {
    if (params == null || params[0] == null) {
      return false;
    }
    try {
      return Long.parseLong(params[0]) % 2 == 0;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}
