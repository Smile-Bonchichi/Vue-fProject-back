package kstu.kg.VuefProjectBack.service;

import kstu.kg.VuefProjectBack.dto.request.ProfileDtoRequest;
import kstu.kg.VuefProjectBack.dto.response.ProfileDtoResponse;

public interface ProfileService {
    ProfileDtoResponse updateUserName(ProfileDtoRequest profileDtoRequest);
}
