package kstu.kg.VuefProjectBack.service.impl;

import kstu.kg.VuefProjectBack.dto.request.UserAuthDtoRequest;
import kstu.kg.VuefProjectBack.dto.resoinse.UserAuthDtoResponse;
import kstu.kg.VuefProjectBack.entity.User;
import kstu.kg.VuefProjectBack.exception.UserNotCorrectPasswordException;
import kstu.kg.VuefProjectBack.exception.UserNotFoundException;
import kstu.kg.VuefProjectBack.exception.UserSignUpException;
import kstu.kg.VuefProjectBack.mapper.UserMapper;
import kstu.kg.VuefProjectBack.service.AuthService;
import kstu.kg.VuefProjectBack.service.database.RoleService;
import kstu.kg.VuefProjectBack.service.database.UserService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Collections;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    final UserService userService;

    final RoleService roleService;

    final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserService userService,
                           RoleService roleService,
                           PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAuthDtoResponse signUp(UserAuthDtoRequest userAuthDtoRequest) {
        User user = UserMapper.INSTANCE.toUserEntity(userAuthDtoRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsActive(1L);

        if (user.getLogin().equalsIgnoreCase("admin")) {
            user.setRoles(Collections.singletonList(roleService.getById(1L)));
        } else {
            user.setRoles(Collections.singletonList(roleService.getById(2L)));
        }
        if (userService.saveOrUpdate(user) == null) {
            throw new UserSignUpException("Не удалось создать пользователя", HttpStatus.BAD_REQUEST);
        }

        return getToken(userAuthDtoRequest);
    }

    @Override
    public UserAuthDtoResponse signIn(UserAuthDtoRequest userAuthDtoRequest) {
        User user = userService.findByLogin(userAuthDtoRequest.getLogin());

        if (user == null) {
            throw new UserNotFoundException("Такого пользователя нет", HttpStatus.BAD_REQUEST);
        }

        if (passwordEncoder.matches(userAuthDtoRequest.getPassword(), user.getPassword())) {
            return getToken(userAuthDtoRequest);
        } else {
            throw new UserNotCorrectPasswordException("Неправильный логин или пароль", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public UserAuthDtoResponse forgotPassword(UserAuthDtoRequest userAuthDtoRequest) {
        return null;
    }

    private UserAuthDtoResponse getToken(UserAuthDtoRequest userAuthDtoRequest) {
        return UserAuthDtoResponse.builder()
                .token("Basic " + new String(Base64.getEncoder()
                                .encode((userAuthDtoRequest.getLogin() + ":" + userAuthDtoRequest.getPassword()).getBytes())
                        )
                ).build();
    }
}
