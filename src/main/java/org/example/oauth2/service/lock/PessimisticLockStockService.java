package org.example.oauth2.service.lock;

import lombok.RequiredArgsConstructor;
import org.example.oauth2.entity.Stock;
import org.example.oauth2.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PessimisticLockStockService {
    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdWithPessimisticLock(id);
        stock.decrementQuantity(quantity);
        stockRepository.save(stock);
    }
}
