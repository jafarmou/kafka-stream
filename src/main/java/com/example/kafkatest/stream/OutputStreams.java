package com.example.kafkatest.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputStreams {

    String NOTIFICATION_V4 = "notificationV4";

    @Output(NOTIFICATION_V4)
    MessageChannel notificationV4();

}
