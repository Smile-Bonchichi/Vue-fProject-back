package kstu.kg.VuefProjectBack.service.database;

import kstu.kg.VuefProjectBack.entity.User;
import kstu.kg.VuefProjectBack.service.base.CrudService;

public interface UserService extends CrudService<User> {
    User findByLogin(String login);
}
