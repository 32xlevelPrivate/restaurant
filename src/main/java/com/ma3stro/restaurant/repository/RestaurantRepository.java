package com.ma3stro.restaurant.repository;

import com.ma3stro.restaurant.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> getAll();

    Restaurant get(int id);

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);
}
