package com.ma3stro.restaurant.service;

import com.ma3stro.restaurant.model.User;
import com.ma3stro.restaurant.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User get(int id) throws NotFoundException;

    User create(User user);

    void update(User user);

    void delete(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;
}
