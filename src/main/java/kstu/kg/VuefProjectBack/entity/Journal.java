package kstu.kg.VuefProjectBack.entity;

import kstu.kg.VuefProjectBack.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "journal_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Journal extends BaseEntity {
    @Column(name = "amount", nullable = false)
    BigDecimal amount;

    @Column(name = "description")
    String description;

    @Column(name = "type", nullable = false)
    String type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
