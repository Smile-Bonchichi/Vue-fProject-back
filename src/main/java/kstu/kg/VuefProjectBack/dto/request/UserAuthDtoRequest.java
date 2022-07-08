package kstu.kg.VuefProjectBack.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAuthDtoRequest {
    @Size(max = 20, min = 5)
    @NotNull
    String login;

    @Email
    @Size(max = 50, min = 5)
    String email;

    @Size(max = 50, min = 8)
    @NotNull
    String password;
}
