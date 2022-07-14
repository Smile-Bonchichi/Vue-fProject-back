package kstu.kg.VuefProjectBack.controller;

import kstu.kg.VuefProjectBack.dto.request.RecordDtoRequest;
import kstu.kg.VuefProjectBack.dto.response.RecordDtoResponse;
import kstu.kg.VuefProjectBack.service.RecordAddedService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/record/")
@CrossOrigin
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecordController {
    final RecordAddedService recordAddedService;

    @Autowired
    public RecordController(RecordAddedService recordAddedService) {
        this.recordAddedService = recordAddedService;
    }

    @PostMapping("add-new-record")
    public ResponseEntity<RecordDtoResponse> updateProfileName(@Valid @RequestBody RecordDtoRequest recordDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recordAddedService.addedNewRecord(recordDtoRequest));
    }
}
