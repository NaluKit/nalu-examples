package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractCompositeCondition;

import java.util.Objects;

public class DetailCompositeCondition
    extends AbstractCompositeCondition<NaluSimpleApplicationContext> {

  @Override
  public boolean loadComposite(String route,
                               String... parms) {
    if (Objects.isNull(parms)) {
      return false;
    }
    if (Objects.isNull(parms[0])) {
      return false;
    }
    if ("1".equals(parms[0])) {
      return true;
    }
    return false;
  }

}
