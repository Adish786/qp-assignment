package com.notification.utility;


import com.notification.entity.EmailHistory;
import com.notification.entity.SmsHistory;
import com.notification.entity.WhatsappHistory;
import com.notification.model.history.EmailHistoryRequest;
import com.notification.model.history.SmsHistoryRequest;
import com.notification.model.history.WhatsappHistoryRequest;

public class NotificationHistoryUtility {

  public static SmsHistory buildSmsHistory(SmsHistoryRequest smsHistoryRequest) {
    return ObjectMapperUtility.convertValue(smsHistoryRequest, SmsHistory.class);
  }

  public static EmailHistory buildEmailHistory(
      EmailHistoryRequest emailHistoryRequest) {
    return ObjectMapperUtility.convertValue(emailHistoryRequest, EmailHistory.class);
  }

  public static WhatsappHistory buildWhatsappHistory(
      WhatsappHistoryRequest whatsappHistoryRequest) {
    return ObjectMapperUtility.convertValue(whatsappHistoryRequest, WhatsappHistory.class);
  }

  private NotificationHistoryUtility() {

  }

}
