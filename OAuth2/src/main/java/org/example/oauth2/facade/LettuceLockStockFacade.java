package org.example.oauth2.facade;

import lombok.RequiredArgsConstructor;
import org.example.oauth2.repository.RedisLockRepository;
import org.example.oauth2.service.StockService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LettuceLockStockFacade {
    private final RedisLockRepository redisLockRepository;
    private final StockService stockService;

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while (!redisLockRepository.lock(id)) {
            // lock 획득에 실패했다면 100MS 텀을 두고 lock 획득 제시도
            // 이렇게 하는 이유는 레디스의 부하를 줄이기 위해서
            Thread.sleep(100);
        }

        try {
            stockService.decrease(id, quantity);
        } finally {
            redisLockRepository.unLock(id);
        }
    }
}
