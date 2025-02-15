package org.example.oauth2.config.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class CouponCreateProducer {
    private final KafkaTemplate<String, Long> kafkaTemplate;

    public void create(Long userId) {
        log.info("동작함");
        kafkaTemplate.send("coupon_create", userId);
    }
}
