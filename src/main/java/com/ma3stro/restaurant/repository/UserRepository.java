package com.ma3stro.restaurant.repository;

import com.ma3stro.restaurant.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    // null if not found
    User get(int id);

    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User getByEmail(String email);
}
