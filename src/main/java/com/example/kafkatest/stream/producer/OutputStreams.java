package com.example.kafkatest.stream.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface OutputStreams {

    String NOTIFICATION_V4 = "notificationV4";

    @Output(NOTIFICATION_V4)
    MessageChannel notificationV4();

}
