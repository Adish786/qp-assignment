package com.notification.consumer;

import com.notification.utility.ObjectMapperUtility;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaTopicConsumer {

  @KafkaListener(topics = {"#{'${app.kafka.consumer.topic}'.split(',')}"})
  public void receive(ConsumerRecord<String, String> consumerRecord) {
    com.notification.model.NotificationPayload basePayload = ObjectMapperUtility.readValue(consumerRecord.value(),
            com.notification.model.NotificationPayload.class);
  }
  @KafkaListener(topics = {"#{'${app.kafka.consumer.topic.dlt}'.split(',')}"})
  public void listenDlt(ConsumerRecord<String, String> consumerRecord,
      @Header(KafkaHeaders.DLT_EXCEPTION_STACKTRACE) String exceptionStackTrace) {
    log.error(exceptionStackTrace);
  }
}
