package org.example.oauth2.facade;

import lombok.RequiredArgsConstructor;
import org.example.oauth2.repository.LockRepository;
import org.example.oauth2.service.StockService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NamedLockStockFacade {
    private final LockRepository lockRepository;
    private final StockService stockService;

    @Transactional
    public void decrease(Long id, Long quantity){
        try {
            lockRepository.getLock(id.toString());
            stockService.decrease(id, quantity);
        }finally {
            lockRepository.releaseLock(id.toString());
        }
    }
}
