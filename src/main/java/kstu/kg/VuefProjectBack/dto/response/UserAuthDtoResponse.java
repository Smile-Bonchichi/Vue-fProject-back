package kstu.kg.VuefProjectBack.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAuthDtoResponse {
    String token;

    String userName;

    String currency;

    BigDecimal amount;
}
