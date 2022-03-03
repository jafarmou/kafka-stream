package com.example.kafkatest;

import com.example.kafkatest.util.NotificationService;
import com.kian.notification.dto.v4.NotificationRequestV4Dto;
import com.kian.notification.enumeration.NotificationChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class GeneralController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/rest")
    public Boolean sendSMSRest(
            @RequestParam("mobile") String mobile,
            @RequestParam("message") String message) {

        return notificationService.sendNotificationInternalBulk(
                NotificationChannel.SMS, Set.of(mobile), message);
    }

    @GetMapping("/kafka")
    public Boolean sendSMSKafka(@RequestParam String mobile, @RequestParam String message) {

        return notificationService.sendNotificationInternalBulkKAFKA(
                NotificationChannel.SMS, Set.of(mobile), message);
    }


}
