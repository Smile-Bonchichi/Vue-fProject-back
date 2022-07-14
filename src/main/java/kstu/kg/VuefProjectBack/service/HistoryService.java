package kstu.kg.VuefProjectBack.service;

import kstu.kg.VuefProjectBack.dto.response.HistoryDtoResponse;

import java.util.List;

public interface HistoryService {
    List<HistoryDtoResponse> getAllRecordsUser();
}
