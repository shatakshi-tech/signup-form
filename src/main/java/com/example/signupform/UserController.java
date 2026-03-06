package com.example.signupform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // Root page
    @RequestMapping("/")
    public String home() {
        return "User sign up page";
    }


    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @RequestMapping("/users/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }


    @RequestMapping(value="/change-password", method=RequestMethod.PUT)
    public String changePassword(@RequestBody PasswordChangeRequest request) {
        return userService.changePassword(
                request.getEmail(),
                request.getOldPassword(),
                request.getNewPassword()
        );
    }
}
