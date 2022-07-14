package kstu.kg.VuefProjectBack.service.impl;

import kstu.kg.VuefProjectBack.dto.request.ProfileDtoRequest;
import kstu.kg.VuefProjectBack.dto.response.ProfileDtoResponse;
import kstu.kg.VuefProjectBack.entity.User;
import kstu.kg.VuefProjectBack.exception.UserNotFoundException;
import kstu.kg.VuefProjectBack.service.ProfileService;
import kstu.kg.VuefProjectBack.service.database.UserService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileServiceImpl implements ProfileService {
    final UserService userService;

    @Autowired
    public ProfileServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ProfileDtoResponse updateUserName(ProfileDtoRequest profileDtoRequest) {
        User user = userService.findByLogin(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()
        );

        if (user == null)
            throw new UserNotFoundException("Пользователя с таким токеном нет", HttpStatus.BAD_REQUEST);

        String oldName = user.getLogin();
        user.setLogin(profileDtoRequest.getUserName());
        userService.saveOrUpdate(user);

        return ProfileDtoResponse.builder()
                .oldName(oldName)
                .newName(user.getLogin())
                .build();
    }
}
