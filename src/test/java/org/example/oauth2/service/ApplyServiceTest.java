package org.example.oauth2.service;

import org.assertj.core.api.Assertions;
import org.example.oauth2.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplyServiceTest {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private CouponRepository couponRepository;

    @Test
    void 한번만응모() {
        applyService.apply(1L);
        long count = couponRepository.count();

        Assertions.assertThat(count).isEqualTo(1);
    }
}