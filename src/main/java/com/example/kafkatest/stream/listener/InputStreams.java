package com.example.kafkatest.stream.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface InputStreams {

    String NOTIFICATION_V4 = "notificationV4";
    
    @Input(NOTIFICATION_V4)
    MessageChannel notificationV4();

}
