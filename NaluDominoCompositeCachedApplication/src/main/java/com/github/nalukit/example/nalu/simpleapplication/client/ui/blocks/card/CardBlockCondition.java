package com.github.nalukit.example.nalu.simpleapplication.client.ui.blocks.card;

import com.github.nalukit.nalu.client.component.IsShowBlockCondition;

public class CardBlockCondition
    implements IsShowBlockCondition {

  @Override
  public boolean showBlock(String route,
                           String... params) {
    if (route.contains("search")) {
      return false;
    }
    return true;
  }

}
