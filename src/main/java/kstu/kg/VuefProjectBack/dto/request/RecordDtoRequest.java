package kstu.kg.VuefProjectBack.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecordDtoRequest {
    String type;

    BigDecimal amount;

    String description;
}
