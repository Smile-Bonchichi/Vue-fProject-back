package kstu.kg.VuefProjectBack.service.database.impl;

import kstu.kg.VuefProjectBack.entity.Role;
import kstu.kg.VuefProjectBack.repository.RoleRepository;
import kstu.kg.VuefProjectBack.service.base.impl.CrudServiceImpl;
import kstu.kg.VuefProjectBack.service.database.RoleService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceImpl extends CrudServiceImpl<Role> implements RoleService {
    final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }
}
