package org.example.oauth2.repository;

import jakarta.persistence.LockModeType;
import org.example.oauth2.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<Stock, Long> {

    // 비관적 락(Pessimistic Lock)
    // 이 쿼리를 실행하는 동안 다른 트랜잭션이 동일한 데이터를 수정하는 것을 차단
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Stock s where s.id = :id")
    Stock findByIdWithPessimisticLock(Long id);
}
