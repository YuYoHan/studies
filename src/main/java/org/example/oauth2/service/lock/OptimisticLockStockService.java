package org.example.oauth2.service.lock;

import lombok.RequiredArgsConstructor;
import org.example.oauth2.entity.StockEntity;
import org.example.oauth2.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OptimisticLockStockService {
    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long quantity) {
        StockEntity stock = stockRepository.findByIdWithOptimisticLock(id);
        stock.decrementQuantity(quantity);
        stockRepository.save(stock);
    }
}
