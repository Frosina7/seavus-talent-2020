package com.seavus.talent.notes.api;


import com.seavus.talent.notes.model.User;
import com.seavus.talent.notes.security.SecurityService;
import com.seavus.talent.notes.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    private SecurityService securityService;


    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping("/api/users")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @GetMapping("/api/users/me")
    public User findAuthenticatedUser() {
        return securityService.getAuthenticatedUser();
    }


}
