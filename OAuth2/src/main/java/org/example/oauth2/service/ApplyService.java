package org.example.oauth2.service;

import lombok.RequiredArgsConstructor;
import org.example.oauth2.entity.CouponEnitiy;
import org.example.oauth2.repository.CouponCountRepository;
import org.example.oauth2.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {
    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    public void apply(Long userId) {
        Long count = couponCountRepository.increment();

        if(count > 100) {
            return;
        }

        couponRepository.save(CouponEnitiy.builder().userId(userId).build());

    }
}
