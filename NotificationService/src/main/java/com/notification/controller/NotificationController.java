package com.notification.controller;

import java.util.Map;

import com.notification.utility.ObjectMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

  @Autowired
  private KafkaTemplate kafkaTemplate;

  @PostMapping("/notification/send")
  public ResponseEntity<Object> sendNotification(@RequestBody Map<String, Object> payload) {
    try {
      kafkaTemplate.send("Notification", "NotificationKey",
          ObjectMapperUtility.writeValueAsString(payload));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return ResponseEntity.ok().build();
  }

}
