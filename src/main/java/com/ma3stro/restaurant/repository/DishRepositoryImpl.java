package com.ma3stro.restaurant.repository;

import com.ma3stro.restaurant.model.Dish;
import com.ma3stro.restaurant.repository.crud.CrudDishRepository;
import com.ma3stro.restaurant.repository.crud.CrudRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {

    @Autowired
    private CrudDishRepository crudDishRepository;

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Override
    public List<Dish> getAll(LocalDate date, int restaurantId) {
        return crudDishRepository.findAll(date, restaurantId);
    }

    @Override
    public List<Dish> getBetween(LocalDate fromDate, LocalDate toDate, int restaurantId) {
        return crudDishRepository.getBetween(fromDate, toDate, restaurantId);
    }

    @Override
    public Dish get(int id, int restaurantId) {
        return crudDishRepository.findByIdAndRestaurantId(id, restaurantId).orElse(null);
    }

    @Override
    public Dish save(Dish dish, int restaurantId) {
        if(!dish.isNew() && get(dish.getId(), restaurantId) == null) {
            return null;
        }
        dish.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        return crudDishRepository.save(dish);
    }

    @Override
    public boolean delete(int id, int restaurantId) {
        return crudDishRepository.delete(id, restaurantId) != 0;
    }
}
