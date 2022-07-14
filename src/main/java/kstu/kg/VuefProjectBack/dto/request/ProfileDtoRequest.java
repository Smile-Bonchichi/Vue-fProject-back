package kstu.kg.VuefProjectBack.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileDtoRequest {
    @Size(max = 20, min = 5)
    String userName;
}
