package de.gishmo.example.devk.shared.model.transport.response;

import de.gishmo.example.devk.shared.model.AbstractDto;
import org.dominokit.jackson.annotation.JSONMapper;

@JSONMapper
public class Status
    extends AbstractDto {

  public static final String OK                     = "200";
  public static final String NOT_FOUND              = "404";
  public static final String CONFLICT               = "409";
  public static final String TECHNICAL_SERVER_ERROR = "500";
  public static final String NOT_AUTHORIZED         = "511";
  public static final String BUSINESS_ERROR         = "900";

  /* Returncode des Calls */
  private String returnCode;
  //  /* Liste der fachlichen Meldungen */
  //  private List<ClMessage> businessMessage;
  //  /* Technische Fehlermeildung */
  //  private String          technicalMessage;

  public Status() {
    this(null,
         null);
  }

  public Status(String returnCode) {
    this(returnCode,
         null);
  }

  public Status(String returnCode,
                String technicalMessage) {
    this.returnCode = returnCode;
    //    this.technicalMessage = technicalMessage;
    //    this.businessMessage = new ArrayList<>();
  }

  public String getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  //  public String getTechnicalMessage() {
  //    return technicalMessage;
  //  }
  //
  //  public void setTechnicalMessage(String technicalMessage) {
  //    this.technicalMessage = technicalMessage;
  //  }
  //
  //  public List<ClMessage> getBusinessMessage() {
  //    return businessMessage;
  //  }
  //
  //  public void setBusinessMessage(List<ClMessage> businessMessage) {
  //    this.businessMessage = businessMessage;
  //  }

}
