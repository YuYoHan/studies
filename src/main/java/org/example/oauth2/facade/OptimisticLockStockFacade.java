package org.example.oauth2.facade;

import lombok.RequiredArgsConstructor;
import org.example.oauth2.service.lock.OptimisticLockStockService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptimisticLockStockFacade {
    private final OptimisticLockStockService optimisticLockStockService;


    public void decrease(Long id, Long quantity) throws InterruptedException {
        while (true) {
            try {
                optimisticLockStockService.decrease(id, quantity);
                break;
            } catch (Exception e) {
                Thread.sleep(50);
            }
        }
    }
}
