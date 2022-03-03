package com.example.kafkatest.stream.listener;

import com.example.kafkatest.util.NotificationService;
import com.kian.notification.dto.v4.NotificationRequestV4Dto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
//@EnableIntegration
public class NotificationListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationListener.class);

    private final NotificationService notificationService;

    public NotificationListener(NotificationService notificationServiceV4) {
        this.notificationService = notificationServiceV4;
    }

    @StreamListener(InputStreams.NOTIFICATION)
    public void handle(@Payload Message<NotificationRequestV4Dto> request) {
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

        notificationService.sendNotificationInternalBulkTwo(payload);
    }

}