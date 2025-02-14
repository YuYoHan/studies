package org.example.oauth2.repository;

import jakarta.persistence.LockModeType;
import org.example.oauth2.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

    // 비관적 락(Pessimistic Lock)
    // 이 쿼리를 실행하는 동안 다른 트랜잭션이 동일한 데이터를 수정하는 것을 차단
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from StockEntity s where s.id = :id")
    StockEntity findByIdWithPessimisticLock(Long id);

    // 낙관적 락은 데이터 정합성을 유지하면서도 락을 최소화하는 방식
    // 별도의 락을 잡지 않으므로 성능에 장점이 있지만
    // 업데이트가 실패했을 때 개발자가 직접 재시도 로직을 구현해야 한다.
    // 충돌이 빈번하게 일어날거라고 생각한다면 비관적 락을 사용해야한다.
    // 충돌이란 낙관적 락을 사용하는 트랜잭션들이 동일한 데이터를 동시에 수정하려 할 때 발생하는 버전 불일치 상황
    @Lock(LockModeType.OPTIMISTIC)
    @Query("select s from StockEntity s where s.id = :id")
    StockEntity findByIdWithOptimisticLock(Long id);
}
