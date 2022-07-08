package kstu.kg.VuefProjectBack.service.database.impl;

import kstu.kg.VuefProjectBack.entity.User;
import kstu.kg.VuefProjectBack.repository.UserRepository;
import kstu.kg.VuefProjectBack.service.base.impl.CrudServiceImpl;
import kstu.kg.VuefProjectBack.service.database.UserService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {
    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.getByLogin(login);
    }
}
