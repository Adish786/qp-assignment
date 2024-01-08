package com.notification.model;


import java.util.ArrayList;
import java.util.List;

import com.notification.utility.CommonConstants;
import lombok.Data;

@Data
public class NotificationPayload {

  String appId;
  List<String> destinations = new ArrayList<>(); // For Whatsapp comm, destination will be used.
  String message;

  TemplatePayload templatePayload;

  CommonConstants.Language language = CommonConstants.Language.ENGLISH;

}
