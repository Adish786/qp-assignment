package com.notification.model.history;

import com.notification.utility.CommonConstants;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BaseNotificationHistoryRequest {

  String appId;

  @NotBlank(message = "message id is mandatory.")
  String messageId;

  String content;
  String templateName;
  String templateData;

  String notificationRequest;
  CommonConstants.Status status;
  String errorMessage;
  String thirdPartyResponse;

}
