package com.example.kafkatest.config;

import com.example.kafkatest.stream.OutputStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {OutputStreams.class})
public class StreamConfiguration {
}
