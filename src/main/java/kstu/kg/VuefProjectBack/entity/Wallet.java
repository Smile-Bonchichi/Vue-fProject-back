package kstu.kg.VuefProjectBack.entity;

import kstu.kg.VuefProjectBack.entity.base.BaseEntity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Wallet extends BaseEntity {
    @Column(name = "amount")
    BigDecimal amount;

    @Column(name = "currency")
    String currency;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    User user;
}
