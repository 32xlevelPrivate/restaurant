package com.ma3stro.restaurant.repository.crud;

import com.ma3stro.restaurant.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {
    @Query("SELECT d FROM Dish d WHERE d.date=:date and d.restaurant.id=:restaurantId")
    List<Dish> findAll(@Param("date") LocalDate date, @Param("restaurantId") int restaurantId);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurantId AND d.date BETWEEN :fromDate AND :toDate")
    List<Dish> getBetween(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate,
                          @Param("restaurantId") int restaurantId);

    Optional<Dish> findByIdAndRestaurantId(Integer id, Integer restaurantId);

    @Transactional
    Dish save(Dish item);

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId")
    int delete(@Param("id") int id, @Param("restaurantId") int restaurantId);
}
