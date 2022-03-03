package com.example.kafkatest.util;

import com.example.kafkatest.stream.OutputStreams;
import com.kian.notification.dto.v4.NotificationRequestV4Dto;
import com.kian.notification.dto.v4.NotificationResponseV4Dto;
import com.kian.notification.enumeration.NotificationChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class NotificationService {

    @Autowired
    private OutputStreams outputStreams;



    public boolean sendNotificationInternalBulk(NotificationChannel channel, Set<String> targets, String body) {
        NotificationRequestV4Dto dto = createNotificationRequestV4DtoBulk(channel, targets, body);
        return sendNotificationInternalBulkTwo(dto);
    }

    public boolean sendNotificationInternalBulkTwo(NotificationRequestV4Dto dto) {
        try {
            String url = "http://localhost:8080/api/v4/notification";
            ResponseEntity<List<NotificationResponseV4Dto>> result = new RestTemplate().exchange(url, HttpMethod.POST,
                    new HttpEntity<>(dto), new ParameterizedTypeReference<>() {
                    });

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private NotificationRequestV4Dto createNotificationRequestV4DtoBulk(NotificationChannel channel, Set<String> targets, String body) {
        NotificationRequestV4Dto dto = new NotificationRequestV4Dto();
        dto.setChannel(channel);
        NotificationRequestV4Dto.RequestItem reqItem = new NotificationRequestV4Dto.RequestItem();
        reqItem.setBody(body);
        reqItem.setRecipient(targets);
        dto.setItems(Arrays.asList(reqItem));
        return dto;
    }

    public boolean sendNotificationInternalBulkKAFKA(NotificationChannel channel, Set<String> targets, String body) {
        NotificationRequestV4Dto dto = createNotificationRequestV4DtoBulk(channel, targets, body);
        try {
            outputStreams.notificationV4().send(
                    MessageBuilder
                            .withPayload(dto)
                            .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                            .build());

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
