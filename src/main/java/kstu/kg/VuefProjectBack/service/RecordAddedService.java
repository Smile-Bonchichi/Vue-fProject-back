package kstu.kg.VuefProjectBack.service;

import kstu.kg.VuefProjectBack.dto.request.RecordDtoRequest;
import kstu.kg.VuefProjectBack.dto.response.RecordDtoResponse;

public interface RecordAddedService {
    RecordDtoResponse addedNewRecord(RecordDtoRequest recordDtoRequest);
}
