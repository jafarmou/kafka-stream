package com.example.kafkatest.stream.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface InputStreams {

    String NOTIFICATION = "notification";
    
    @Input(NOTIFICATION)
//    SubscribableChannel notification();
    MessageChannel notification();

}
