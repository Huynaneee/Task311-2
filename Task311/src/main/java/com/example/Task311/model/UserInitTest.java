package com.example.Task311.model;

import com.example.Task311.mappers.RoleMappers;
import com.example.Task311.mappers.UserMappers;
import com.example.Task311.service.RoleService;
import com.example.Task311.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Component
public class UserInitTest {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserInitTest(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void generateUsersTest() {

        Role role1 = new Role(1L,"ROLE_USER");
        Role role2 = new Role(2L, "ROLE_ADMIN");

        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);

        User admin = new User("Andrey", "Chernysow", "sda@yandex.ri", "101", Collections.singleton(role2));
        User user = new User("Misha", "Galustyan", "p2p@gmail.ci", "102", Collections.singleton(role1));
        User testUser = new User("Luna","Moon","moon21@sda", "100",roles);


        roleService.addRole(RoleMappers.ROLE_MAPPERS.fromUserRole(role1));
        roleService.addRole(RoleMappers.ROLE_MAPPERS.fromUserRole(role2));

        userService.addUser(UserMappers.USER_MAPPERS.fromDtouser(admin));
        userService.addUser(UserMappers.USER_MAPPERS.fromDtouser(user));
        userService.addUser(UserMappers.USER_MAPPERS.fromDtouser(testUser));




    }
}
