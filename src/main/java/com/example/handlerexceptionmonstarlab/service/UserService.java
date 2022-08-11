package com.example.handlerexceptionmonstarlab.service;

import com.example.handlerexceptionmonstarlab.model.User;
import com.example.handlerexceptionmonstarlab.model.UserCollection;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    User getUserNoException(Long id);

    User createUser(User user);

    List<User> getUserCollection(UserCollection userCollection);
}
