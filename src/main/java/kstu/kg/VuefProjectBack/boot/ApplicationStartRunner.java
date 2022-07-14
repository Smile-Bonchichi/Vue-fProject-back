package kstu.kg.VuefProjectBack.boot;

import kstu.kg.VuefProjectBack.entity.Role;
import kstu.kg.VuefProjectBack.service.database.RoleService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationStartRunner implements CommandLineRunner {
    final RoleService roleService;

    @Autowired
    public ApplicationStartRunner(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
//        roleService.saveOrUpdate(Role.builder()
//                .roleName("ROLE_ADMIN")
//                .build());
//
//        roleService.saveOrUpdate(Role.builder()
//                .roleName("ROLE_USER")
//                .build());
    }
}
