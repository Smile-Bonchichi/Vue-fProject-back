package kstu.kg.VuefProjectBack.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryDtoResponse {
    Long rowNumber;

    BigDecimal amount;

    LocalDateTime recordDate;

    String description;

    String type;
}
