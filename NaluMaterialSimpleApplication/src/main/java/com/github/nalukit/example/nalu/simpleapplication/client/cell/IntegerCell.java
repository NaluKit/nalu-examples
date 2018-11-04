package com.github.nalukit.example.nalu.simpleapplication.client.cell;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class IntegerCell
    extends AbstractCell<Integer> {

  @Override
  public void render(com.google.gwt.cell.client.Cell.Context context,
                     Integer value,
                     SafeHtmlBuilder sb) {
    if (value != null) {
      sb.appendEscaped(value.toString());
    }
  }
}
