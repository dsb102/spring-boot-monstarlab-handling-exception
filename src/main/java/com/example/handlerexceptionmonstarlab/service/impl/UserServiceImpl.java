package com.example.handlerexceptionmonstarlab.service.impl;

import com.example.handlerexceptionmonstarlab.controller.exceptionhandler.notfoundexception.EntityNotFoundException;
import com.example.handlerexceptionmonstarlab.model.User;
import com.example.handlerexceptionmonstarlab.model.UserCollection;
import com.example.handlerexceptionmonstarlab.repository.UserRepository;
import com.example.handlerexceptionmonstarlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserNoException(Long id) {
        return userRepository.findUserById(id);
    }

    public User getUser(Long id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            System.out.println("Không tìm thấy");
            throw new EntityNotFoundException(User.class, "id", id.toString());
        }
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUserCollection(UserCollection userCollection) {
        List<User> users = new ArrayList<>();
        userCollection.getUsersIds().forEach(userId -> {
            User user = userRepository.findUserById(userId);
            if (user == null)
                throw new EntityNotFoundException(User.class, "id", userId.toString());
            users.add(user);
        });
        return users;
    }
}