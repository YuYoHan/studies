package org.example.oauth2.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2.config.kafka.producer.CouponCreateProducer;
import org.example.oauth2.entity.CouponEnitiy;
import org.example.oauth2.repository.CouponCountRepository;
import org.example.oauth2.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {
    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;

    public void apply(Long userId) {
        Long count = couponCountRepository.increment();

        if(count > 100) {
            return;
        }

        couponCreateProducer.create(userId);

    }
}
