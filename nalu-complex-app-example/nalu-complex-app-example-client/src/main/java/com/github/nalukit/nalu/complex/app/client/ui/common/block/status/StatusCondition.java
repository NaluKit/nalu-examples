package com.github.nalukit.nalu.complex.app.client.ui.common.block.status;

import com.github.nalukit.nalu.client.component.IsShowBlockCondition;
import com.github.nalukit.nalu.client.util.NaluUtils;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;

public class StatusCondition
    implements IsShowBlockCondition {

  @Override
  public boolean showBlock(String route,
                           String... params) {
    return !NaluUtils.get()
                     .compareRoutes(route,
                                    Routes.ROUTE_LOGON);
  }

}
