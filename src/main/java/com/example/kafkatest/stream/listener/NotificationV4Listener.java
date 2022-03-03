package com.example.kafkatest.stream.listener;

import com.example.kafkatest.util.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kian.notification.dto.v4.NotificationRequestV4Dto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class NotificationV4Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationV4Listener.class);

    private final NotificationService notificationServiceV4;

    public NotificationV4Listener(NotificationService notificationServiceV4) {
        this.notificationServiceV4 = notificationServiceV4;
    }

//    @StreamListener(value = InputStreams.NOTIFICATION_V4)
    public void handle(Message<NotificationRequestV4Dto> request) {
        NotificationRequestV4Dto payload = request.getPayload();
/*        try {
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            String payloadStr = mapper.writeValueAsString(payload);
            LOGGER.info(">>>>>>>>>>>>>>>>>>>> received payload:");
            LOGGER.info(payloadStr);
        } catch (Exception e) {
            LOGGER.error("An error occured while converting payload json");
            LOGGER.error(e.getMessage(), e);
        }*/

        notificationServiceV4.sendNotificationInternalBulkTwo(payload);
    }

}