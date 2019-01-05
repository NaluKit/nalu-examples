package com.github.nalukit.example.nalu.simpleapplication.client.cell;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class HoursMinutesCell
    extends AbstractCell<Integer> {

  public static String formatHoursMinutes(int minutes) {
    final int hours = minutes / 60;
    final int remain = minutes % 60;

    StringBuffer result = new StringBuffer();

    result.append(hours);

    if (remain < 10) {
      result.append(":0")
            .append(remain);
    } else {
      result.append(":")
            .append(remain);
    }

    return result.toString();
  }

  @Override
  public void render(com.google.gwt.cell.client.Cell.Context context,
                     Integer value,
                     SafeHtmlBuilder sb) {
    if (value != null) {
      sb.appendEscaped(formatHoursMinutes(value));
    }
  }

}
