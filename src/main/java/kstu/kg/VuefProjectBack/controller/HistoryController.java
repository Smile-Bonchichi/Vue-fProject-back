package kstu.kg.VuefProjectBack.controller;

import kstu.kg.VuefProjectBack.dto.response.HistoryDtoResponse;
import kstu.kg.VuefProjectBack.service.HistoryService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history/")
@CrossOrigin
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryController {

    final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("get-all")
    public ResponseEntity<List<HistoryDtoResponse>> getAllHistoryUser() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(historyService.getAllRecordsUser());
    }
}
