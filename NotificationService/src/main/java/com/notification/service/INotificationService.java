package com.notification.service;


import com.notification.model.NotificationHandlerResponse;
import com.notification.model.NotificationPayload;
import com.notification.model.history.BaseNotificationHistoryRequest;
import com.notification.utility.CommonConstants;

public interface INotificationService {

  default NotificationHandlerResponse notify(NotificationPayload request) {
    NotificationHandlerResponse response = new NotificationHandlerResponse();
    try {
      sendNotification(request, response);
      if (CommonConstants.Status.FAILED_AT_THIRD_PARTY != response.getStatus()) {
        response.setStatus(CommonConstants.Status.SUCCESS);
      }
    } catch (Exception e) {
      response.setStatus(CommonConstants.Status.FAILED);
      response.setErrorMessage(
          String.format("%s failed with error: %s", this.getClass().getSimpleName(),
              e.getMessage()));
    }
    return response;
  }

  void sendNotification(NotificationPayload request, NotificationHandlerResponse response);

  void createHistory(BaseNotificationHistoryRequest request);

  void updateHistory(BaseNotificationHistoryRequest request);

}
