package com.notification.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper= true)
public class EmailNotificationPayload extends NotificationPayload {

  String subject;

}
