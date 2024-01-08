package com.notification.model;

import com.notification.utility.CommonConstants;
import com.notification.utility.ObjectMapperUtility;
import lombok.Data;

@Data
public class NotificationHandlerResponse {

  String messageId;
  CommonConstants.Status status;
  String errorMessage;
  String thirdPartyResponse;

  public void addThirdPartyResponse(Object thirdPartyResponseObj) {
    this.thirdPartyResponse = ObjectMapperUtility.writeValueAsString(thirdPartyResponseObj);
    if ("{}".equalsIgnoreCase(this.thirdPartyResponse)) {
      this.thirdPartyResponse = thirdPartyResponseObj.toString();
    }
  }


}
