package com.example.handlerexceptionmonstarlab.controller;

import com.example.handlerexceptionmonstarlab.controller.exceptionhandler.notfoundexception.EntityNotFoundException;
import com.example.handlerexceptionmonstarlab.model.User;
import com.example.handlerexceptionmonstarlab.model.UserCollection;
import com.example.handlerexceptionmonstarlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") Long userId) throws EntityNotFoundException {
        return userService.getUser(userId);
    }

    @GetMapping(value = "/collection")
    public List<User> getUserValid(@RequestBody UserCollection userCollection) throws EntityNotFoundException{
        return userService.getUserCollection(userCollection);
    }

    @GetMapping(value = "/noexception/{userId}")
    public User getUserNotException(@PathVariable("userId") Long userId) throws EntityNotFoundException{
        return userService.getUserNoException(userId);
    }

    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }
}
