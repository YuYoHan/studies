package org.example.oauth2.repository;

import org.example.oauth2.entity.CouponEnitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponEnitiy, Long> {
}
