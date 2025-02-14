package org.example.oauth2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class StockEntity {
    @Id @GeneratedValue
    private Long id;

    private Long productId;
    private Long quantity;

    @Version
    private Long version;

    public void decrementQuantity(Long amount) {
        if(this.quantity - amount < 0) {
            throw new RuntimeException("재고는 0개 미만이 될 수 없습니다.");
        }
        this.quantity -= amount;
    }

}
