package org.example.oauth2.service;

import org.example.oauth2.entity.StockEntity;
import org.example.oauth2.repository.StockRepository;
import org.example.oauth2.service.lock.PessimisticLockStockService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockEntityServiceTest {
    @Autowired
    private PessimisticLockStockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    void before() {
        stockRepository.save(
                new StockEntity()
                        .builder()
                        .productId(1L)
                        .quantity(100L)
                        .build());
    }

    @AfterEach
    void after() {
        stockRepository.deleteAll();
    }

    @Test
    void 재고감소() {
        stockService.decrease(1L, 1L);
        StockEntity stockEntity = stockRepository.findById(1L).orElseThrow();

        Assertions.assertEquals(99, stockEntity.getQuantity());
    }

    @Test
    void 동시에_100개의_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    stockService.decrease(1L, 1L);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();

        StockEntity stockEntity = stockRepository.findById(1L).orElseThrow();
        // 100 - (1 * 100) = 0
        assertEquals(0, stockEntity.getQuantity());
    }
}