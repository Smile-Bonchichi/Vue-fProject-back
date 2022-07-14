package kstu.kg.VuefProjectBack.controller;

import kstu.kg.VuefProjectBack.dto.request.ProfileDtoRequest;
import kstu.kg.VuefProjectBack.dto.response.ProfileDtoResponse;
import kstu.kg.VuefProjectBack.service.ProfileService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/profile/")
@CrossOrigin
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileController {

    final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("update-user-name")
    public ResponseEntity<ProfileDtoResponse> updateProfileName(@Valid @RequestBody ProfileDtoRequest profileDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(profileService.updateUserName(profileDtoRequest));
    }
}
