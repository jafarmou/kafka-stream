package com.example.kafkatest.config;

import com.example.kafkatest.stream.producer.OutputStreams;
import com.example.kafkatest.stream.listener.InputStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

//@Configuration
@EnableBinding(value = {OutputStreams.class, InputStreams.class})
public class StreamConfiguration {
}
