package com.ma3stro.restaurant.repository;

import com.ma3stro.restaurant.model.Dish;

import java.time.LocalDate;
import java.util.List;

public interface DishRepository {
    List<Dish> getAll(LocalDate date, int restaurantId);

    List<Dish> getBetween(LocalDate fromDate, LocalDate toDate, int restaurantId);

    Dish get(int id, int restaurantId);

    Dish save(Dish dish, int restaurantId);

    boolean delete(int id, int restaurantId);
}
