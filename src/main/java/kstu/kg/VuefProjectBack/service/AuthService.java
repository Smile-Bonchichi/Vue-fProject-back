package kstu.kg.VuefProjectBack.service;

import kstu.kg.VuefProjectBack.dto.request.UserAuthDtoRequest;
import kstu.kg.VuefProjectBack.dto.response.UserAuthDtoResponse;

public interface AuthService {
    UserAuthDtoResponse signUp(UserAuthDtoRequest userAuthDtoRequest);

    UserAuthDtoResponse signIn(UserAuthDtoRequest userAuthDtoRequest);

    UserAuthDtoResponse forgotPassword(UserAuthDtoRequest userAuthDtoRequest);
}
